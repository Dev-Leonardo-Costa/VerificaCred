package br.com.leonardocosta.msavalidadorcredito.application.exception;

public class ErroSolicitacaoCartaoException extends RuntimeException {

    public ErroSolicitacaoCartaoException(String message) {
        super(message);
    }
}
