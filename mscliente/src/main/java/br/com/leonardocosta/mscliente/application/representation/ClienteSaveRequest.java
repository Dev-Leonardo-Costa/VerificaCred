package br.com.leonardocosta.mscliente.application.representation;

import br.com.leonardocosta.mscliente.domain.Cliente;
import lombok.Data;

@Data
public class ClienteSaveRequest {

    private String cpf;
    private String nome;
    private Integer idade;

   public Cliente toModel() {
        return new Cliente(cpf, nome, idade);
    }

}
