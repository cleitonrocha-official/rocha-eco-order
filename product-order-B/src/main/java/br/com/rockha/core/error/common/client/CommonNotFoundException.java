package br.com.rockha.core.error.common.client;

import br.com.rockha.core.common.CommonException;

public class CommonNotFoundException extends CommonException {

    private static final String TITULO = "Recurso não encontrado";

    public CommonNotFoundException(String message) {
        super(TITULO, message);
    }

    public CommonNotFoundException(String message, Throwable cause) {
        super(TITULO, message, cause);
    }
}