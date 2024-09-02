package com.javarush.shirokova.controller;

import com.javarush.shirokova.service.FileProcessor;
import com.javarush.shirokova.util.Messages;
import com.javarush.shirokova.model.Operation;
import com.javarush.shirokova.util.PathNameValidator;
import com.javarush.shirokova.view.UserInterface;

/**
 * Class for user interaction through a console menu.
 */
public class ConsoleMenu {
    private final UserInterface userInterface;
    private final FileProcessor fileProcessor;


    /**
     * Constructor for creating a ConsoleMenu instance.
     *
     * @param userInterface Object implementing UserInterface for user input.
     * @param fileProcessor FileProcessor object for file processing.
     */
    public ConsoleMenu(UserInterface userInterface, FileProcessor fileProcessor) {
        this.userInterface = userInterface;
        this.fileProcessor = fileProcessor;
    }

    /**
     * Runs the menu loop for user interaction.
     */
    public void run() {

        userInterface.showWelcomeMessage();

        while (true) {
            userInterface.showMenu();
            String choice = userInterface.getUserInput(Messages.PROMPT_CHOICE);
            int operationNumber;
            try {
                operationNumber = Integer.parseInt(choice);
            } catch (NumberFormatException e) {
                System.err.println(Messages.ERROR_INVALID_CHOICE_NOT_NUMBER);
                operationNumber = -1;
            }
            Operation operation = Operation.fromNumber(operationNumber);
            if (operation == Operation.EXIT) {
                operation.execute();
                break;
            }
            if (operation == null) {
                System.out.println(Messages.ERROR_INVALID_CHOICE);
                continue;
            }
            operation.execute();

            switch (operation) {
                case ENCRYPT:
                    performFileProcessing(true);
                    break;
                case DECRYPT:
                    performFileProcessing(false);
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Perform file processing based on the operation type.
     *
     * @param isEncryption Indicates if the operation is encryption or decryption.
     */
    private void performFileProcessing(boolean isEncryption) {
        String inputFile = userInterface.getUserInput(Messages.PROMPT_INPUT_FILE);
        if (inputFile.isEmpty()) { // Check for empty input
            if (!isEncryption) {
                inputFile = PathNameValidator.DEFAULT_ENCRYPTED_FILE_PATH; // Use default input encrypted file
            } else {
                inputFile = PathNameValidator.DEFAULT_INPUT_FILE_PATH; // Use default input file
            }
            System.out.println(Messages.DEFAULT_INPUT_FILE_MESSAGE + inputFile);
        }

        String outputFile = userInterface.getUserInput(Messages.PROMPT_OUTPUT_FILE);
        if (outputFile.isEmpty()) { // Check for empty input
            if (isEncryption) {
                outputFile = PathNameValidator.DEFAULT_ENCRYPTED_FILE_PATH; // Use default output encrypted file

            } else {
                outputFile = PathNameValidator.DEFAULT_DECRYPTED_FILE_PATH; // Use default output decrypted file
            }
            System.out.println(Messages.DEFAULT_OUTPUT_FILE_MESSAGE + outputFile);
        }

        int key;

        try {
            key = Integer.parseInt(userInterface.getUserInput(Messages.PROMPT_KEY));
        } catch (NumberFormatException e) {
            System.err.println(Messages.ERROR_INVALID_KEY);
            return;
        }
        fileProcessor.processFile(inputFile, outputFile, key, isEncryption);
    }
}