package com.mm.kafka_example.model;

public class KafkaOperationError {

    private final String message;
    private final Exception exception;

    public KafkaOperationError(String msg) {
        this(msg, null);
    }

    public KafkaOperationError(String msg, Exception e) {
        message=msg;
        exception=e;
    }

    public String getMessage() {
        return message;
    }

    public Exception getException() {
        return exception;
    }
}
