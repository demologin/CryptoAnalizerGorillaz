package com.javarush.siberia.menu;

import com.javarush.siberia.exception.AppException;
import com.javarush.siberia.controllers.MainController;
import com.javarush.siberia.entity.Result;

import java.util.Arrays;

public class ConsoleApplication {

    private final MainController mainController;
    public ConsoleApplication() {
        mainController = new MainController();
    }

    public Result run(String[] args) {
        if (args.length > 0) {
            String action = args[0];
            String[] parameters = Arrays.copyOfRange(args, 1, args.length);
            return mainController.doAction(action, parameters);
        } else {
            throw new AppException("no args");
        }
    }
}