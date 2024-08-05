package com.javarush.shosafoev.exceptions;

public class WrongKeyException extends RuntimeException {
    public WrongKeyException(String wrongLengthOfKey) {
        super(wrongLengthOfKey);
    }
}
