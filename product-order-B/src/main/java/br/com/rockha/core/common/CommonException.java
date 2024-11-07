package br.com.rockha.core.common;

import lombok.Getter;

@Getter
public class CommonException extends RuntimeException{

    private final String title;
    private static final String TITLE = "Erro Não Mapeado";


    public CommonException( String message) {
        super(message);
        this.title = TITLE;
    }

    public CommonException(String title, String message) {
        super(message);
        this.title = title;
    }

    public CommonException(String title,String message, Throwable cause) {
        super(message, cause);
        this.title = title;
    }

}
