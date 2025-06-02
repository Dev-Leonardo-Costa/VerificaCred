package br.com.leonardocosta.mscartoes.representation.controller;

import br.com.leonardocosta.mscartoes.application.port.in.CriarCartaoUseCase;
import br.com.leonardocosta.mscartoes.application.service.ClienteCartaoService;
import br.com.leonardocosta.mscartoes.domain.model.Cartao;
import br.com.leonardocosta.mscartoes.domain.model.ClienteCartao;
import br.com.leonardocosta.mscartoes.representation.DTOs.CartaoRequest;
import br.com.leonardocosta.mscartoes.representation.DTOs.CartoesPorClienteResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cartoes")
public class CartoesController {

    private final CriarCartaoUseCase criarCartaoUseCase;

    private final ClienteCartaoService clienteCartaoService;

    @GetMapping
    public String status() {
        return "ok";
    }

    @PostMapping
    public ResponseEntity cadastrarCartao(@RequestBody CartaoRequest cartaoRequest) {
        Cartao model = cartaoRequest.toModel();
        Cartao cartao = criarCartaoUseCase.save(model);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(params = "renda")
    public ResponseEntity<List<Cartao>> getCartoesRendaMenorIgual(@RequestParam("renda") Long renda) {
        List<Cartao> list = criarCartaoUseCase.getCartoesRendaMenorIgual(renda);
        return ResponseEntity.ok(list);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<CartoesPorClienteResponse>> getCartoesByCpf(@RequestParam("cpf") String cpf) {
        List<ClienteCartao> lista = clienteCartaoService.getCartoesByCpf(cpf);
        List<CartoesPorClienteResponse> resultList = lista.stream()
                .map(CartoesPorClienteResponse::fromModel)
                .collect(Collectors.toList());
        return ResponseEntity.ok(resultList);
    }

}
