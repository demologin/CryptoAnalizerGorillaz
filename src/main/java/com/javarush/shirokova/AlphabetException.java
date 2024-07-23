package com.javarush.shirokova;

public class AlphabetException extends RuntimeException {

    String reason;

    public AlphabetException(String reason) {
        this.reason = reason;
    }

    public AlphabetException(String reason, Throwable cause) {
        super(cause);
        this.reason = reason;
    }

    public String getReason() {
        return this.reason;
    }
}