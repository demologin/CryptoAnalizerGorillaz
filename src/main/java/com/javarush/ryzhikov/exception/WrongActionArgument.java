package com.javarush.ryzhikov.exception;


import com.javarush.ryzhikov.entity.ResultCode;

public class WrongActionArgument extends IllegalArgumentException {

    private final String message ;
    private final ResultCode resultCode = ResultCode.ERROR ;
    public WrongActionArgument(String message) {
        this.message = message;
    }
    public WrongActionArgument() {
        this.message = "Не найдена команда";
    }

}
