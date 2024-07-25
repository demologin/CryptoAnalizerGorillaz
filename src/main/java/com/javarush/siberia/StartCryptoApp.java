package com.javarush.siberia;

import com.javarush.siberia.entity.Result;

public class StartCryptoApp {
    public static void main(String[] args) {
        System.out.println("My super app");

        Application application = new Application();
        Result result = application.run(args);
        System.out.println(result);
    }
}