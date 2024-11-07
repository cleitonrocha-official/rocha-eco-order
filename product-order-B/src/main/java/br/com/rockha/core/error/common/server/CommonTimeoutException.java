package br.com.rockha.core.error.common.server;

import br.com.rockha.core.common.CommonException;

public class CommonTimeoutException extends CommonException {

    private static final String TITULO = "Tempo de resposta excedido";

    public CommonTimeoutException(String message) {
        super(TITULO, message);
    }

    public CommonTimeoutException(String message, Throwable cause) {
        super(TITULO, message, cause);
    }
}