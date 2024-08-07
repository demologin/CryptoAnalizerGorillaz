package com.javarush.kartsev.commands;

import com.javarush.kartsev.constant.Constans;
import com.javarush.kartsev.entity.Result;
import com.javarush.kartsev.entity.ResultCode;

public class Exit  extends AbstractAction{
    @Override
    public Result execute(String[] parameters) {
        return new Result(ResultCode.OK, Constans.APPLICATION_CLOSED);
    }
}
