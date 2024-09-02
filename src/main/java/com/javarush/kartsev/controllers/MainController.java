package com.javarush.kartsev.controllers;

import com.javarush.kartsev.commands.Action;
import com.javarush.kartsev.entity.Result;
import com.javarush.kartsev.entity.ResultCode;
import com.javarush.kartsev.exception.AppException;

public class MainController {

    public Result doAction(String actionName, String[] parameters) {
        Action action = ActionContainer.get(actionName);
        try {
            return action.execute(parameters);
        } catch (NumberFormatException | AppException e) {
            return new Result(ResultCode.ERROR, e.getMessage());
        }
    }
}
