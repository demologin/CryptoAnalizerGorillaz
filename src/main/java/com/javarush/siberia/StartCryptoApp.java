package com.javarush.siberia;

import com.javarush.siberia.constants.Constants;
import com.javarush.siberia.menu.Menu;

public class StartCryptoApp {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("Добро пожаловать в примитивный шифровальщик, который Цезарь завещал.");
        System.out.println(Constants.ALPHABET_LENGTH_TXT);

        Application application = new Application();
        Menu menu = new Menu(application);
        menu.showMenu();
    }
}