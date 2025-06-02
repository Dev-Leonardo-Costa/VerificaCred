package br.com.leonardocosta.mscartoes.domain.model;

public enum BandeiraCartao {

    VISA("Visa"),
    MASTERCARD("Mastercard"),
    ELO("Elo"),
    AMERICAN_EXPRESS("American Express");

    private final String descricao;

    BandeiraCartao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
