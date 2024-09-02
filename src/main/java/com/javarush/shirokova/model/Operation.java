package com.javarush.shirokova.model;

import com.javarush.shirokova.util.Messages;

/**
 * Enum representing different operations for file processing.
 */
public enum Operation {
    EXIT(0, Messages.MENU_OPTION_0, () -> System.out.println(Messages.EXIT_MESSAGE)),
    ENCRYPT(1, Messages.MENU_OPTION_1, () -> System.out.println(Messages.ENCRYPT_MESSAGE)),
    DECRYPT(2, Messages.MENU_OPTION_2, () -> System.out.println(Messages.DECRYPT_MESSAGE));

    private final int number;
    private final String description;
    private final Runnable action;

    Operation(int number, String description, Runnable action) {
        this.number = number;
        this.description = description;
        this.action = action;
    }

    /**
     * Get the number associated with the operation.
     *
     * @return The operation number.
     */
    public int getNumber() {
        return number;
    }

    /**
     * Get the description of the operation.
     *
     * @return The operation description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Execute the action associated with the operation.
     */
    public void execute() {
        action.run();
    }

    /**
     * Get an Operation by its number.
     *
     * @param number The number of the operation.
     * @return The corresponding Operation or null if not found.
     */
    public static Operation fromNumber(int number) {
        for (Operation operation : values()) {
            if (operation.getNumber() == number) {
                return operation;
            }
        }
        return null; // Return null if operation not found
    }
}