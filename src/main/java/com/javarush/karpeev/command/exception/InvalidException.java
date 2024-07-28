package com.javarush.karpeev.command.exception;

public class InvalidException extends RuntimeException {
    public InvalidException() {

    }

    public InvalidException(String message) {
        super(message);
    }

    public InvalidException(String message, Throwable cause) {
        super(message, cause);
    }
}
