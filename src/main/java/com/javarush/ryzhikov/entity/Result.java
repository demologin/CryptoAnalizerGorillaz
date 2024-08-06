package com.javarush.ryzhikov.entity;

public class Result {

    private final String message;
    private final ResultCode resultCode;

    //public static final Result DEFGAULT_EMPTY_RESULT = new Result("", ResultCode.EMPTY);

    public Result(String message, ResultCode resultCode) {
        this.message = message;
        this.resultCode = resultCode;
    }

    @Override
    public String toString() {
        return "Result{" +
                "message='" + message + '\'' +
                ", resultCode=" + resultCode +
                '}';
    }

}

