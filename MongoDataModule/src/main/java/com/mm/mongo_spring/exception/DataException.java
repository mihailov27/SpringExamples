package com.mm.mongo_spring.exception;

public class DataException extends RuntimeException {

    public DataException(String message) {
        super(message);
    }

    public DataException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public DataException(Throwable throwable) {
        super(throwable);
    }
}
