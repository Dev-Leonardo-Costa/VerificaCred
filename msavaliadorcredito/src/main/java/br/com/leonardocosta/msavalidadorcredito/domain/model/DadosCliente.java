package br.com.leonardocosta.msavalidadorcredito.domain.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DadosCliente {

    private Long id;
    private String nome;
    private Integer idade;

}
