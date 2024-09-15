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
    private final PathNameValidator pathNameValidator;


    /**
     * Constructor for creating a ConsoleMenu instance.
     *
     * @param userInterface Object implementing UserInterface for user input.
     * @param fileProcessor FileProcessor object for file processing.
     */
    public ConsoleMenu(UserInterface userInterface, FileProcessor fileProcessor) {
        this.userInterface = userInterface;
        this.fileProcessor = fileProcessor;
        this.pathNameValidator = new PathNameValidator(userInterface);
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
                userInterface.showMessage(Messages.ERROR_INVALID_CHOICE);
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
        String inputFile = getValidatedFilePath(isEncryption, true);
        String outputFile = getValidatedFilePath(isEncryption, false);

        int key;

        try {
            key = Integer.parseInt(userInterface.getUserInput(Messages.PROMPT_KEY));
        } catch (NumberFormatException e) {
            System.err.println(Messages.ERROR_INVALID_KEY);
            return;
        }
        fileProcessor.processFile(inputFile, outputFile, key, isEncryption);
    }

    /**
     * Prompts the user for a file path and validates it.
     *
     * @param isEncryption indicates if it's an input or output file path.
     * @param isForReading indicates if it's a file for reading or writing.
     * @return validated file path from the user.
     */
    private String getValidatedFilePath(boolean isEncryption, boolean isForReading) {
        String filePath;
        String message = isForReading
                ? Messages.PROMPT_INPUT_FILE
                : Messages.PROMPT_OUTPUT_FILE;

        String defaultFileMessage = isForReading
                ? Messages.DEFAULT_INPUT_FILE_MESSAGE
                : Messages.DEFAULT_OUTPUT_FILE_MESSAGE;

        while (true) {
            filePath = userInterface.getUserInput(message);

            if (filePath.isEmpty()) { // default
                filePath = pathNameValidator.getDefaultPath(isEncryption, isForReading);
                userInterface.showMessage(defaultFileMessage + filePath);
                return filePath;
            } else if (isForReading) {// entered
                if (pathNameValidator.isPathValidForReading(filePath)) {
                    return filePath;
                }
            } else { // entered
                if (pathNameValidator.isPathValidForWriting(filePath)) {
                    return filePath;
                }
            }
            userInterface.showMessage(Messages.ERROR_TRY_ENTER_PATH_AGAIN);
        }
    }
}