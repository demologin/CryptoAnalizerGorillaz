package com.javarush.myasnikov.console;
import com.javarush.myasnikov.inputs.FileHandler;
import  com.javarush.myasnikov.utilities.Alphabet;
import static com.javarush.myasnikov.console.ConsoleText.*;
import static com.javarush.myasnikov.utilities.Command.*;

public class ConsoleApp {
    ConsoleMenu consoleMenu = new ConsoleMenu();
    ConsoleInput consoleInput = new ConsoleInput();
    FileHandler fileHandler = new FileHandler();
    int menuSelectionNumber = 0;
    String message;


    public ConsoleApp() {
        while (true) {
            System.out.println(MENU_TEXT);
            menuSelectionNumber = consoleInput.enterConsoleNumber();
            switch (menuSelectionNumber) {
                case 1: {
                    message = consoleMenu.selectConsoleOption(message, ENCRYPT);
                    break;
                }
                case 2: {
                    message = consoleMenu.selectConsoleOption(message, DECRYPT);
                    break;
                }
                case 3: {
                    message = consoleMenu.selectConsoleOption(message, BRUTE_FORCE);
                    break;
                }
                case 4: {
                    System.out.println(Alphabet.ALPHABET + '\n');
                    break;
                }
                case 5: {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default:
                    System.out.println("You've entered an invalid option.");
            }
        }
    }
}
