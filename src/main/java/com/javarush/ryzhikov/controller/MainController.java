package com.javarush.ryzhikov.controller;

import com.javarush.ryzhikov.command.Action;
import com.javarush.ryzhikov.entity.Actions;
import com.javarush.ryzhikov.entity.Result;
import com.javarush.ryzhikov.entity.ResultCode;
import com.javarush.ryzhikov.exception.WrongActionArgument;

public class MainController {


    public Result doAction(String actionName, String[] parameters) {
            Action action = Actions.findAction(actionName);
            Result result = action.execute(parameters);
            return result;
    }
}
