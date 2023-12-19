package com.code.exception;

public class InternalServerErrorException extends RuntimeException {

    public  InternalServerErrorException(String message) {
        super(message);
    }
}
