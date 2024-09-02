package com.javarush.shirokova.view;

/**
 * Interface for user interaction.
 */
public interface UserInterface {
    /**
     * Displays the menu of options.
     */
    void showMenu();

    /**
     * Gets input from the user with the specified prompt.
     *
     * @param prompt String - prompt for input.
     * @return User-entered string.
     */
    String getUserInput(String prompt);

    /**
     * Displays a welcome message to the user.
     */
    void showWelcomeMessage();
}