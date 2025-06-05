package br.com.leonardocosta.msavalidadorcredito.application;

import br.com.leonardocosta.msavalidadorcredito.application.exception.DadosClienteNotFounfException;
import br.com.leonardocosta.msavalidadorcredito.application.exception.ErroDeCominicacaoMicroserviceException;
import br.com.leonardocosta.msavalidadorcredito.domain.model.DadosAvaliacao;
import br.com.leonardocosta.msavalidadorcredito.domain.model.RetornoAvaliacaoCliente;
import br.com.leonardocosta.msavalidadorcredito.domain.model.SituacaoCliente;
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
    public ResponseEntity consultaSituacaoCliente(@RequestParam("cpf") String cpf) {
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

}
