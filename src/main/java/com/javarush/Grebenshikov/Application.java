package com.javarush.Grebenshikov;

import com.javarush.Grebenshikov.Control.MainController;

import java.lang.reflect.Array;

public class Application {
    private MainController mainController;
    public Application() {
         mainController = new MainController();


    }






    public NiceResult go(String[] args) {
        if(args.length>0){

            String action = args[0];

        }
        return null;
    }
}

