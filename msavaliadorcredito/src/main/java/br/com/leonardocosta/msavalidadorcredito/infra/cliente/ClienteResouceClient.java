package br.com.leonardocosta.msavalidadorcredito.infra.cliente;

import br.com.leonardocosta.msavalidadorcredito.domain.model.Cartao;
import br.com.leonardocosta.msavalidadorcredito.domain.model.DadosCliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

// comunicação sicrona
@FeignClient(value = "msclientes", path = "/clientes")
public interface ClienteResouceClient {

    @GetMapping(params = "cpf")
    ResponseEntity<DadosCliente> dadosCliente(@RequestParam("cpf") String cpf);

}
