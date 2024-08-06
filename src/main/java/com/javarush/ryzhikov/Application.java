package com.javarush.ryzhikov;

import com.javarush.ryzhikov.controller.MainController;
import com.javarush.ryzhikov.entity.Result;

import java.util.Arrays;

public class Application {
    private final MainController mainController;

    Application() {
        mainController = new MainController();
    }

    public Result run(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(Arrays.toString(args));
        String action = args[0];
        String[] parameters = Arrays.copyOfRange(args, 1, args.length);
        Result result = mainController.doAction(action, parameters);
        long end = System.currentTimeMillis();
        System.out.println( (end - start) / 1000.0 + " seconds");

        return result;
    }

}
