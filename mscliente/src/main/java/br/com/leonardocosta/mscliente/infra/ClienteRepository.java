package br.com.leonardocosta.mscliente.infra;

import br.com.leonardocosta.mscliente.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByCpf(String cpf); // certo: cpf minúsculo
}
