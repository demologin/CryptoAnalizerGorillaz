package com.javarush.siberia;

import com.javarush.siberia.menu.Menu;

public class StartCryptoApp {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("Добро пожаловать в примитивный шифровальщик, который Цезарь завещал.");

        Application application = new Application();
        Menu menu = new Menu(application);
        menu.showMenu();
    }
}