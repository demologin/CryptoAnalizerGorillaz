package com.javarush.ryzhikov.entity;

import com.javarush.ryzhikov.command.Action;
import com.javarush.ryzhikov.command.Decode;
import com.javarush.ryzhikov.command.Encode;
import com.javarush.ryzhikov.exception.WrongActionArgument;

public enum Actions {
    DECODE(new Decode()),
    ENCODE(new Encode());

    private Action action;


    Actions(Action action) {
        this.action = action;
    }

    public static Action findAction(String actionName) {
        try {
            Actions value = Actions.valueOf(actionName.trim().toUpperCase());
            return value.action;
        } catch (IllegalArgumentException ex) {
            throw new WrongActionArgument();
        }

    }

}
