package com.javarush.siberia.commands;

import com.javarush.siberia.entity.Result;
import com.javarush.siberia.entity.ResultCode;

public class Encoder implements Action{
    @Override
    public Result execute(String[] parameters) {

        return new Result("encode all right", ResultCode.OK);
    }
}