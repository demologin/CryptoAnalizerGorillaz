package com.javarush.myasnikov.console;

import com.javarush.myasnikov.inputs.FileHandler;
import  com.javarush.myasnikov.processors.CryptoProcessor;
import  com.javarush.myasnikov.utilities.Command;
import static  com.javarush.myasnikov.utilities.Alphabet.ALPHABET;
import static com.javarush.myasnikov.console.ConsoleText.*;

class ConsoleMenu {
    private final ConsoleInput consoleInput = new ConsoleInput();

    public void displayMenuOptions(Command command) {
        switch (command) {
            case ENCRYPT:
                System.out.println(ENCRYPTION_OPTIONS_TEXT);
                break;
            case DECRYPT:
                System.out.println(DECRYPTION_OPTIONS_TEXT);
                break;
            case BRUTE_FORCE:
                System.out.println(BRUTE_FORCE_OPTIONS_TEXT);
                break;
        }
    }

    public String enterMessage() {
        System.out.println("Enter a text:");
        return consoleInput.enterConsoleText();
    }

    public int enterKey () {
        System.out.println("Enter a key:");
        return consoleInput.enterConsoleNumber();
    }

    public String processMessage(String message, int key, Command command) {
            try {
                CryptoProcessor cryptoProcessor = new CryptoProcessor(ALPHABET, message, key, command);
                message = cryptoProcessor.getMessage();
                System.out.println("Message processed: " + message + '\n');
                return message;
            } catch (NullPointerException e) {
                System.out.println("You've should enter a message first.");
            }
        return "";
    }

    public void displayMessage(CryptoProcessor cryptoProcessor) {
            try {
                System.out.println(cryptoProcessor.getMessage());
            } catch (NullPointerException e) {
                System.out.println("You should enter a message first.");
            }
    }

    public String selectConsoleOption(String inputMessage, Command processorCommand) {
        ConsoleMenu consoleMenu = new ConsoleMenu();
        int inputKey = 0;
        int menuSelectionNumber = 0;
        String outputMessage = "";

        while (menuSelectionNumber != 4) {
            consoleMenu.displayMenuOptions(processorCommand);
            menuSelectionNumber = consoleInput.enterConsoleNumber();
            switch (menuSelectionNumber) {
                case 1:
                    if (inputMessage == null || inputMessage.isEmpty()) {
                        inputMessage = consoleMenu.enterMessage();
                    }
                    else {
                        System.out.println("Used message: " + inputMessage);
                    }
                    inputKey = consoleMenu.enterKey();
                    break;
                case 2:
                    if (inputMessage == null || inputMessage.isEmpty() || inputKey == 0) {
                        System.out.println("You should enter a message and(or) key. Use option 1. ");
                    }
                    else {
                        outputMessage = consoleMenu.processMessage(inputMessage, inputKey, processorCommand);
                        break;
                    }
                case 3:
                    if (outputMessage == null || outputMessage.isEmpty()) {
                        System.out.println("Currently message is empty. " +
                                "You should encrypt or decrypt a message first.");
                    }
                    else {
                        System.out.println(outputMessage);
                    }
                    break;
                case 4:
                    break;
                default:
                    System.out.println("You've entered an invalid option.");
                    break;
            }
        }
        return outputMessage;
    }

}
