package br.com.rockha.core.error.invalidarg;

import br.com.rockha.core.error.common.client.CommonInvalidArgumentException;

public class OrderCreateException extends CommonInvalidArgumentException {

    private static final String MENSAGEM = "Erro ao criar o pedido, dados inválidaos.";

    public OrderCreateException() {
        super(MENSAGEM);
    }
}
