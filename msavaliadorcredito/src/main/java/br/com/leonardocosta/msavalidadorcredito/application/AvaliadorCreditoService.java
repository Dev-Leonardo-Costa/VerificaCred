package br.com.leonardocosta.msavalidadorcredito.application;

import br.com.leonardocosta.msavalidadorcredito.application.exception.DadosClienteNotFounfException;
import br.com.leonardocosta.msavalidadorcredito.application.exception.ErroDeCominicacaoMicroserviceException;
import br.com.leonardocosta.msavalidadorcredito.domain.model.CartaoCliente;
import br.com.leonardocosta.msavalidadorcredito.domain.model.DadosCliente;
import br.com.leonardocosta.msavalidadorcredito.domain.model.SituacaoCliente;
import br.com.leonardocosta.msavalidadorcredito.infra.cliente.CartoesResouceClient;
import br.com.leonardocosta.msavalidadorcredito.infra.cliente.ClienteResouceClient;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AvaliadorCreditoService {

    private final ClienteResouceClient clienteResouceClient;
    private final CartoesResouceClient cartoesResouceClient;

    public SituacaoCliente obterSituacaoCliente(String cpf) throws DadosClienteNotFounfException, ErroDeCominicacaoMicroserviceException {
        try {

            ResponseEntity <DadosCliente> dadosClienteResponse = clienteResouceClient.dadosCliente(cpf);
            ResponseEntity<List<CartaoCliente>> cartoesResponse = cartoesResouceClient.getCartoesByCpf(cpf);

            return SituacaoCliente.builder()
                    .cliente(dadosClienteResponse.getBody())
                    .cartoes(cartoesResponse.getBody())
                    .build();

        }
        catch (FeignException.FeignClientException ex) {
            ex.printStackTrace();
            int status = ex.status();
            if (HttpStatus.NOT_FOUND.value() == status) {
                throw new DadosClienteNotFounfException();
            }

            throw new ErroDeCominicacaoMicroserviceException(ex.getMessage(), status);
        }

    }
}
