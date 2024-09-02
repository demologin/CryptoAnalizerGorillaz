package com.javarush.shirokova.view;

import com.javarush.shirokova.model.Operation;
import com.javarush.shirokova.util.Messages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class for user interaction through the console.
 * It implements the UserInterface to provide methods for displaying a menu and
 * getting input from the user.
 */
public class ConsoleUserInterface implements UserInterface {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Displays the menu options to the user.
     * This method prints the available options to the console,
     * retrieving the menu texts from the Messages class.
     */
    @Override
    public void showMenu() {
        System.out.println(Messages.PROMPT_MENU);
        for (Operation operation : Operation.values()) {
            System.out.println(operation.getNumber() + ". " + operation.getDescription());
        }
    }

    /**
     * Prompts the user for input and returns the user's response.
     *
     * @param prompt the message displayed to the user to prompt for input.
     * @return the user's input as a String, or null if an I/O error occurs.
     */
    @Override
    public String getUserInput(String prompt) {
        System.out.print(prompt);
        try {
            return reader.readLine();
        } catch (IOException e) {
            System.err.println(Messages.ERROR_IO + e.getMessage());
            return null;
        }
    }

    /**
     * Displays a welcome message to the user.
     * This message provides a brief overview of the program's purpose,
     * explaining its functionality and guiding the user on how to get started.
     */
    @Override
    public void showWelcomeMessage() {
        System.out.println(Messages.WELCOME_MESSAGE);
        System.out.println(Messages.FUNCTIONALITY_DESCRIPTION);
        System.out.println();
    }
}