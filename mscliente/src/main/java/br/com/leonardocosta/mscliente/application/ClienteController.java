package br.com.leonardocosta.mscliente.application;

import br.com.leonardocosta.mscliente.application.representation.ClienteSaveRequest;
import br.com.leonardocosta.mscliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("clientes")
@Slf4j
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping
    public String status() {
        log.info("Obtendo o Status do microserviço de clientes");
        return "ok";
    }

    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody ClienteSaveRequest request) {
        Cliente cliente = request.toModel();
        clienteService.save(cliente);
        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(cliente.getCpf())
                .toUri();
        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping(params = "cpf")
    public ResponseEntity dadosCliente(@RequestParam("cpf") String cpf) {
        var cliente = clienteService.getByCpf(cpf);
        if (cliente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(cliente);
    }
}
