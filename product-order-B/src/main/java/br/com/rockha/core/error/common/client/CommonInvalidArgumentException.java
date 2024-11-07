package br.com.rockha.core.error.common.client;

import br.com.rockha.core.common.CommonException;

public class CommonInvalidArgumentException extends CommonException {

    public static final String TITULO = "Argumento inválido";

    public CommonInvalidArgumentException(String message) {
        super(TITULO, message);
    }

    public CommonInvalidArgumentException(String message, Throwable cause) {
        super(TITULO, message, cause);
    }
}