package com.javarush.siberia;

import com.javarush.siberia.entity.Result;

public class StartCryptoApp {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в примитивный шифровальщик, который Цезарь завещал.");

        Application application = new Application();
        Result result = application.run(args);
        System.out.println(result);
    }
}