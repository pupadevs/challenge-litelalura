package com.libreria.peterson.infrastructure.principal;

public class TitleExistsException extends RuntimeException{

    public TitleExistsException(){
        super("Este titulo existe en nuestra base de datos");
    }

}
