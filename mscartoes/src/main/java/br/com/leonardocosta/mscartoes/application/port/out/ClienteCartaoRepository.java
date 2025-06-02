package br.com.leonardocosta.mscartoes.application.port.out;

import br.com.leonardocosta.mscartoes.domain.model.ClienteCartao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteCartaoRepository extends JpaRepository<ClienteCartao, Long> {

    List<ClienteCartao> findByCpf(final String cpf);
}
