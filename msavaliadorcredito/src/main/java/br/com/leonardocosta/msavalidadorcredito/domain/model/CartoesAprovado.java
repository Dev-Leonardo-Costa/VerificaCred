package br.com.leonardocosta.msavalidadorcredito.domain.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartoesAprovado {

    private String cartao;
    private String bandeira;
    private BigDecimal limiteAprovado;

}
