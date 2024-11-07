package br.com.rockha.core.error.common.server;

import br.com.rockha.core.common.CommonException;

public class CommonServiceUnavailableException extends CommonException {

    private static final String TITULO = "Serviço indisponível";

    public CommonServiceUnavailableException(String message) {
        super(TITULO, message);
    }

    public CommonServiceUnavailableException(String message, Throwable cause) {
        super(TITULO, message, cause);
    }
}