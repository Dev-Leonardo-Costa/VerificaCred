package br.com.leonardocosta.msavalidadorcredito.infra.cliente;

import br.com.leonardocosta.msavalidadorcredito.domain.model.CartaoCliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

// comunicação sicrona
@FeignClient(value = "mscartoes", path = "/cartoes")
public interface CartoesResouceClient {


    @GetMapping(params = "cpf")
    ResponseEntity<List<CartaoCliente>> getCartoesByCpf(@RequestParam("cpf") String cpf);

}