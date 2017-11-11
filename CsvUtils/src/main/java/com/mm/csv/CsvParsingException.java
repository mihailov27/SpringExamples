package com.mm.csv;

public class CsvParsingException extends RuntimeException {

    public CsvParsingException(String message) {
        super(message);
    }

    public CsvParsingException(Throwable throwable) {
        super(throwable);
    }

    public CsvParsingException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
