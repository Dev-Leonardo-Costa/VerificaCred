package br.com.leonardocosta.mscartoes.representation.DTOs;

import br.com.leonardocosta.mscartoes.domain.model.ClienteCartao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CartoesPorClienteResponse {


    private String nome;
    private String bandeira;
    private BigDecimal limiteLiberado;

    public static CartoesPorClienteResponse fromModel(ClienteCartao model) {
        return new CartoesPorClienteResponse(
                model.getCartao().getNome(),
                model.getCartao().getBandeira().toString(),
                model.getLimite()
        );
    }

}
