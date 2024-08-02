package com.javarush.karpeev.command.exception;

import java.io.IOException;

public class InvalidException extends IOException {
    public InvalidException() {

    }

    public InvalidException(String message) {
        super(message);
    }

    public InvalidException(String message, Throwable cause) {
        super(message, cause);
    }
}
