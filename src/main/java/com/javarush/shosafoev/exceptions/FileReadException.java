package com.javarush.shosafoev.exceptions;

public class FileReadException extends RuntimeException {
    public FileReadException(String errorReadingOfFile) {
        super(errorReadingOfFile);
    }
}
