package com.javarush.siberia;

public class StartCryptoApp {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("Добро пожаловать в примитивный шифровальщик, который Цезарь завещал.");
        System.out.println();

        Application application = new Application();
        Menu menu = new Menu(application);
        menu.showMenu();
    }
}