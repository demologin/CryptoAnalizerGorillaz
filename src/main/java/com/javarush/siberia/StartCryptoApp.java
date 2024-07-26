package com.javarush.siberia;

public class StartCryptoApp {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("Добро пожаловать в примитивный шифровальщик, который Цезарь завещал.");
        System.out.println();

        Application application = new Application();

        //для теста - удалить ----------------------------------------------------------------
        application.run(new String[]{"encode", "1"});
        System.out.println("Шифрование");

        application.run(new String[]{"decode", "1"});
        System.out.println("Расшифровывание");
        //для теста - удалить ----------------------------------------------------------------

    }
}