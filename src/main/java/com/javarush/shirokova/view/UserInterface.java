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

    /**
     * Displays a message to the user.
     * <p>
     * This method allows the implementation of user interfaces to present
     * messages, instructions, or notifications to the user in a format
     * appropriate for the specific user interface (e.g., console, GUI).
     *
     * @param message the message to be displayed to the user.
     *                It should be a non-null string that provides context
     *                or information relevant to the user.
     */
    void showMessage(String message);
}