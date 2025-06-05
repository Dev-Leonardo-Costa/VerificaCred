package br.com.leonardocosta.msavalidadorcredito.application.exception;

import lombok.Getter;

public class ErroDeCominicacaoMicroserviceException extends Exception {

    @Getter
    private Integer status;

    public ErroDeCominicacaoMicroserviceException(String message, Integer status) {
        super(message);
        this.status = status;
    }
}
