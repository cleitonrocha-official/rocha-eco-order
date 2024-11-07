package br.com.rockha.core.error.common.client;

import br.com.rockha.core.common.CommonException;

public class CommonSecurityException extends CommonException {

    private static final String TITULO = "Erro de segurança";

    public CommonSecurityException(String message) {
        super(TITULO, message);
    }

    public CommonSecurityException(String message, Throwable cause) {
        super(TITULO, message, cause);
    }
}