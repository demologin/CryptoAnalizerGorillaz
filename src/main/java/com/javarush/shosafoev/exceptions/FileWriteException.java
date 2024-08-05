package com.javarush.shosafoev.exceptions;

public class FileWriteException extends RuntimeException {
    public FileWriteException(String errorWritingOfFile) {
        super(errorWritingOfFile);
    }
}
