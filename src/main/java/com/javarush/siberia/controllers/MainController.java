package com.javarush.siberia.controllers;

import com.javarush.siberia.commands.Action;
import com.javarush.siberia.entity.Result;

public class MainController {

    public Result doAction(String actionName, String[] parameters) {
        Action action = Actions.find(actionName);
        return action.execute(parameters);
    }
}