package com.paulovictor.cursomc.services.exceptions;

import java.security.PublicKey;

public class ObjectNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ObjectNotFoundException(String msg){
        super(msg);
    }

    public ObjectNotFoundException(String msg, Throwable cause){
        super(msg,cause);
    }
}
