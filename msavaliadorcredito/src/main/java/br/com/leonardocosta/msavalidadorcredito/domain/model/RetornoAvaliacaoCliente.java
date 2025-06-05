package br.com.leonardocosta.msavalidadorcredito.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Builder
@Data
public class RetornoAvaliacaoCliente {

    private List<CartoesAprovado> cartoes;

}
