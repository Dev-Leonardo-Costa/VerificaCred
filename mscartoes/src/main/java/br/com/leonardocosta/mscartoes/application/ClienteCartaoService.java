package br.com.leonardocosta.mscartoes.application;

import br.com.leonardocosta.mscartoes.domain.ClienteCartao;
import br.com.leonardocosta.mscartoes.infra.ClienteCartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClienteCartaoService {

    private final ClienteCartaoRepository clienteCartaoRepository;

    public List<ClienteCartao> getCartoesByCpf(final String cpf) {
        return clienteCartaoRepository.findByCpf(cpf);
    }

}
