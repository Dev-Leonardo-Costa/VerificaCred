package br.com.leonardocosta.msavalidadorcredito.application.exception;

public class DadosClienteNotFounfException extends Exception {

    public DadosClienteNotFounfException() {
        super("Dados do cliente não encontrados para o CPF informado.");
    }

    public DadosClienteNotFounfException(String message) {
        super(message);
    }
}
