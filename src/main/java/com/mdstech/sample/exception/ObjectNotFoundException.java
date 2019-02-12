package com.mdstech.sample.exception;

public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException(int code, String message) {
        super(message);
    }

}
