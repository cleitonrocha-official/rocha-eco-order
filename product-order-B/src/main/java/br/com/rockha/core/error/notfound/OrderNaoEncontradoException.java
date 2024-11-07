package br.com.rockha.core.error.notfound;

import br.com.rockha.core.error.common.client.CommonNotFoundException;

public class OrderNaoEncontradoException extends CommonNotFoundException {

    private static final String MENSAGEM = "O pedido solicitado não foi encontrado.";

    public OrderNaoEncontradoException() {
        super(MENSAGEM);
    }
}
