package com.javarush.shirokova;

import com.javarush.shirokova.model.Alphabet;
import com.javarush.shirokova.model.CaesarCipher;
import com.javarush.shirokova.model.Cipher;
import com.javarush.shirokova.controller.ConsoleMenu;
import com.javarush.shirokova.service.FileHandler;
import com.javarush.shirokova.service.FileProcessor;
import com.javarush.shirokova.util.TextFileHandler;
import com.javarush.shirokova.view.ConsoleUserInterface;
import com.javarush.shirokova.view.UserInterface;

/**
 * Main class to run the encryption application.
 */
public class Main {
    /**
     * Entry point of the application.
     */
    public static void main(String[] args) {
        Alphabet alphabet = new Alphabet();
        Cipher cipher = new CaesarCipher(alphabet);
        FileHandler fileHandler = new TextFileHandler();
        UserInterface userInterface = new ConsoleUserInterface();
        FileProcessor fileProcessor = new FileProcessor(fileHandler, cipher);
        ConsoleMenu consoleMenu = new ConsoleMenu(userInterface, fileProcessor);

        consoleMenu.run();
    }
}