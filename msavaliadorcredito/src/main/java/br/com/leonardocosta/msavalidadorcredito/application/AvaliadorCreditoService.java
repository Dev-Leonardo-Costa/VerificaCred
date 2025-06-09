package br.com.leonardocosta.msavalidadorcredito.application;

import br.com.leonardocosta.msavalidadorcredito.application.exception.DadosClienteNotFounfException;
import br.com.leonardocosta.msavalidadorcredito.application.exception.ErroDeCominicacaoMicroserviceException;
import br.com.leonardocosta.msavalidadorcredito.application.exception.ErroSolicitacaoCartaoException;
import br.com.leonardocosta.msavalidadorcredito.domain.model.*;
import br.com.leonardocosta.msavalidadorcredito.infra.cliente.CartoesResouceClient;
import br.com.leonardocosta.msavalidadorcredito.infra.cliente.ClienteResouceClient;
import br.com.leonardocosta.msavalidadorcredito.infra.cliente.mqueue.SolicitacaoEmissaoCartaoPublisher;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class AvaliadorCreditoService {

    private final ClienteResouceClient clientesClient;
    private final CartoesResouceClient cartoesResouceClient;
    private final SolicitacaoEmissaoCartaoPublisher solicitacaoEmissaoCartaoPublisher;

    public SituacaoCliente obterSituacaoCliente(String cpf) throws DadosClienteNotFounfException, ErroDeCominicacaoMicroserviceException {
        try {

            ResponseEntity<DadosCliente> dadosClienteResponse = clientesClient.dadosCliente(cpf);
            ResponseEntity<List<CartaoCliente>> cartoesResponse = cartoesResouceClient.getCartoesByCpf(cpf);

            return SituacaoCliente.builder()
                    .cliente(dadosClienteResponse.getBody())
                    .cartoes(cartoesResponse.getBody())
                    .build();

        } catch (FeignException.FeignClientException ex) {
            ex.printStackTrace();
            int status = ex.status();
            if (HttpStatus.NOT_FOUND.value() == status) {
                throw new DadosClienteNotFounfException();
            }

            throw new ErroDeCominicacaoMicroserviceException(ex.getMessage(), status);
        }

    }

    public RetornoAvaliacaoCliente realizarAvaliacao(String cpf, Long renda) throws DadosClienteNotFounfException, ErroDeCominicacaoMicroserviceException {
        try {
            ResponseEntity<DadosCliente> dadosClienteResponse = clientesClient.dadosCliente(cpf);
            ResponseEntity<List<Cartao>> cartoesResponse = cartoesResouceClient.getCartoesRendaMenorIgual(renda);

            List<Cartao> cartoes = cartoesResponse.getBody();
            var listaCartoesAprovados = cartoes.stream().map(cartao -> {

                        DadosCliente dadosCliente = dadosClienteResponse.getBody();

                        BigDecimal limiteBasico = cartao.getLimiteBasico();
                        BigDecimal idadeBD = BigDecimal.valueOf(dadosCliente.getIdade());
                        var fator = idadeBD.divide(BigDecimal.valueOf(10));
                        BigDecimal limiteAprovado = fator.multiply(limiteBasico);

                        CartoesAprovado aprovado = new CartoesAprovado();
                        aprovado.setCartao(cartao.getNome());
                        aprovado.setBandeira(cartao.getBandeira());
                        aprovado.setLimiteAprovado(limiteAprovado);
                        return aprovado;
                    }
            ).collect(Collectors.toList());

            return new RetornoAvaliacaoCliente(listaCartoesAprovados);

        } catch (FeignException.FeignClientException ex) {
            ex.printStackTrace();
            int status = ex.status();
            if (HttpStatus.NOT_FOUND.value() == status) {
                throw new DadosClienteNotFounfException();
            }

            throw new ErroDeCominicacaoMicroserviceException(ex.getMessage(), status);
        }
    }

    public ProtocoloSolicitacaoCartao solicitacaoEmissaoCartao(DadosSolicitacaoEmissaoCartao dados) {
        try {
            solicitacaoEmissaoCartaoPublisher.solicitarCartao(dados);
            var protocolo = UUID.randomUUID().toString();
            return new ProtocoloSolicitacaoCartao(protocolo);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ErroSolicitacaoCartaoException(e.getMessage());
        }
    }
}
