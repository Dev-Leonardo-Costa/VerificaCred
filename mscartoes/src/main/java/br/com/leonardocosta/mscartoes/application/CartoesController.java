package br.com.leonardocosta.mscartoes.application;

import br.com.leonardocosta.mscartoes.domain.Cartao;
import br.com.leonardocosta.mscartoes.representation.CartaoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cartoes")
public class CartoesController {

    private final CartaoService cartaoService;

    @GetMapping
    public String status() {
        return "ok";
    }

    @PostMapping
    public ResponseEntity cadastrarCartao(@RequestBody CartaoRequest cartaoRequest) {
        Cartao model = cartaoRequest.toModel();
        Cartao cartao = cartaoService.save(model);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(params = "renda")
    public ResponseEntity<List<Cartao>> getCartoesRendaMenorIgual(@RequestParam("renda") Long renda) {
        List<Cartao> list = cartaoService.getCartoesRendaMenorIgual(renda);
        return ResponseEntity.ok(list);
    }

}
