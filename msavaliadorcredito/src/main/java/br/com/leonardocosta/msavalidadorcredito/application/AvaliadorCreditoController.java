package br.com.leonardocosta.msavalidadorcredito.application;

import br.com.leonardocosta.msavalidadorcredito.application.exception.DadosClienteNotFounfException;
import br.com.leonardocosta.msavalidadorcredito.application.exception.ErroDeCominicacaoMicroserviceException;
import br.com.leonardocosta.msavalidadorcredito.application.exception.ErroSolicitacaoCartaoException;
import br.com.leonardocosta.msavalidadorcredito.domain.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/avaliacoes-credito")
public class AvaliadorCreditoController {

    private final AvaliadorCreditoService avaliadorCreditoService;

    @GetMapping
    public String avaliarCredito() {
        return "Avaliação de crédito realizada com sucesso!";
    }

    @GetMapping(value = "situacao-cliente", params = "cpf")
    public ResponseEntity consultarSituacaoCliente(@RequestParam("cpf") String cpf) {
        try {
            SituacaoCliente situacaoCliente = avaliadorCreditoService.obterSituacaoCliente(cpf);
            return ResponseEntity.ok(situacaoCliente);
        } catch (DadosClienteNotFounfException e) {
            return ResponseEntity.notFound().build();
        } catch (ErroDeCominicacaoMicroserviceException e) {
            return ResponseEntity.status(HttpStatus.resolve(e.getStatus())).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity realizarAvaliacao(@RequestBody DadosAvaliacao dadosAvaliacao) {
        try {
            RetornoAvaliacaoCliente retornoAvaliacaoCliente = avaliadorCreditoService.realizarAvaliacao(dadosAvaliacao.getCpf(), dadosAvaliacao.getRenda());
            return ResponseEntity.ok(retornoAvaliacaoCliente);
        } catch (DadosClienteNotFounfException e) {
            return ResponseEntity.notFound().build();
        } catch (ErroDeCominicacaoMicroserviceException e) {
            return ResponseEntity.status(HttpStatus.resolve(e.getStatus())).body(e.getMessage());
        }
    }

    @PostMapping(value = "solicitacoes-cartao")
    public ResponseEntity solicitarCartao(@RequestBody DadosSolicitacaoEmissaoCartao dados) {
        try {
            ProtocoloSolicitacaoCartao protocolo = avaliadorCreditoService.solicitacaoEmissaoCartao(dados);
            return ResponseEntity.ok(protocolo);
        } catch (ErroSolicitacaoCartaoException e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

}
