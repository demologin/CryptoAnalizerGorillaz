package com.javarush.siberia;

import com.javarush.siberia.constants.Constants;
import com.javarush.siberia.menu.ConsoleApplication;
import com.javarush.siberia.menu.ConsoleMenu;

public class StartCryptoApp {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("Добро пожаловать в примитивный шифровальщик, который Цезарь завещал.");
        System.out.println(Constants.ALPHABET_LENGTH_TXT);

        ConsoleApplication consoleApplication = new ConsoleApplication();
        ConsoleMenu consoleMenu = new ConsoleMenu(consoleApplication);
        consoleMenu.showMenu();
    }
}