package br.com.leonardocosta.mscartoes.application.service;

import br.com.leonardocosta.mscartoes.application.port.in.CriarCartaoUseCase;
import br.com.leonardocosta.mscartoes.domain.model.Cartao;
import br.com.leonardocosta.mscartoes.application.port.out.CartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CartaoService implements CriarCartaoUseCase {

    private final CartaoRepository cartaoRepository;

    @Override
    @Transactional
    public Cartao save(Cartao cartao) {
        return cartaoRepository.save(cartao);
    }

    @Override
    public List<Cartao> getCartoesRendaMenorIgual(Long renda) {
        var rendaBigDecimal = BigDecimal.valueOf(renda);
        return cartaoRepository.findByRendaLessThanEqual(rendaBigDecimal);
    }
}
