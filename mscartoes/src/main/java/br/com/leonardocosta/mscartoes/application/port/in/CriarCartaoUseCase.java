package br.com.leonardocosta.mscartoes.application.port.in;

import br.com.leonardocosta.mscartoes.domain.model.Cartao;

import java.util.List;

public interface CriarCartaoUseCase {

    Cartao save(Cartao cartao);
    List<Cartao> getCartoesRendaMenorIgual(Long renda);

}
