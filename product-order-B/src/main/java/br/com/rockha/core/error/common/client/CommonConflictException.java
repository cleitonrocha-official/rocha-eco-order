package br.com.rockha.core.error.common.client;

import br.com.rockha.core.common.CommonException;

public class CommonConflictException extends CommonException {

    private static final String TITULO = "Conflito de dados";

    public CommonConflictException(String message) {
        super(TITULO, message);
    }

    public CommonConflictException(String message, Throwable cause) {
        super(TITULO, message, cause);
    }
}