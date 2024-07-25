package com.javarush.siberia.controllers;

import com.javarush.khmelov.exception.AppException;
import com.javarush.siberia.commands.Action;
import com.javarush.siberia.commands.Decoder;
import com.javarush.siberia.commands.Encoder;

public enum Actions {
    ENCODE(new Encoder()),
    DECODE(new Decoder());

    private final Action action;

    Actions(Action action) {
        this.action = action;
    }

    public static Action find(String actionName) {
        try {
            Actions value = Actions.valueOf(actionName.toUpperCase());
            return value.action;
        } catch (IllegalArgumentException e) {
            throw new AppException("not found " + actionName, e);
        }
    }
}