package br.com.rockha.core.error.common.server;

import br.com.rockha.core.common.CommonException;

public class CommonServerErrorException extends CommonException {

    private static final String TITULO = "Erro interno do servidor";

    public CommonServerErrorException(String message) {
        super(TITULO, message);
    }

    public CommonServerErrorException(String message, Throwable cause) {
        super(TITULO, message, cause);
    }
}