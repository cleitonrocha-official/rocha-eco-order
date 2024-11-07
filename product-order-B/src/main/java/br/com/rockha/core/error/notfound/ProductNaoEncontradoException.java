package br.com.rockha.core.error.notfound;

import br.com.rockha.core.error.common.client.CommonNotFoundException;

public class ProductNaoEncontradoException extends CommonNotFoundException {

    private static final String MENSAGEM = "O Produto solicitado não foi encontrado.";

    public ProductNaoEncontradoException() {
        super(MENSAGEM);
    }
}
