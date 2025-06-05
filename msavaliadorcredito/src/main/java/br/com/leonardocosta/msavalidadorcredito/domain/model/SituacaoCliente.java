package br.com.leonardocosta.msavalidadorcredito.domain.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SituacaoCliente {

    private DadosCliente cliente;
    private List<CartaoCliente> cartoes;

}
