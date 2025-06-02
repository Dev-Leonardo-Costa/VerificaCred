package br.com.leonardocosta.mscartoes.representation.DTOs;

import br.com.leonardocosta.mscartoes.domain.model.BandeiraCartao;
import br.com.leonardocosta.mscartoes.domain.model.Cartao;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartaoRequest {

    private String nome;
    private BigDecimal renda;
    private BigDecimal limiteBasico;

    private BandeiraCartao bandeira;

    public Cartao toModel() {
        return new Cartao(nome, bandeira, renda, limiteBasico);
    }

}
