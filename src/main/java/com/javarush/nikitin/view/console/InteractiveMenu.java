package com.javarush.nikitin.view.console;

import com.javarush.nikitin.constants.InputParameter;
import com.javarush.nikitin.constants.Operation;
import com.javarush.nikitin.entity.DataContainer;
import com.javarush.nikitin.exceptions.ApplicationException;

import java.util.Scanner;

public class InteractiveMenu {
    private final Scanner scanner;
    private static final String PATTERN_COMMANDS_MENU = "[0-3]";
    private static final String ENTER_CORRECT_COMMAND = "Enter the correct command\n";
    private static final String MENU = """
             *** Welcome to the menu, select the operation number ***
             1 Encrypt
             2 Decrypt
             3 Brute Force
             0 Exit
            """;

    public InteractiveMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    DataContainer executeMenu() {
        printMessage(MENU);
        return getUserAllResponse();
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

    private void printMessage(String message, String details) {
        System.out.printf("%s: %s\n", message, details);
    }

    private Operation getTypeOperation() {
        while (true) {
            String scanLine = scanner.nextLine();
            if (scanLine.matches(PATTERN_COMMANDS_MENU)) {
                int number = Integer.parseInt(scanLine);
                if (number == 0) {
                    printMessage("Goodbye");
                }
                return Operation.getInstance(number);
            }
            printMessage(ENTER_CORRECT_COMMAND);
            printMessage(MENU);
        }
    }

    private DataContainer getUserAllResponse() {
        Operation type = getTypeOperation();
        return switch (type) {
            case ENCRYPT, DECRYPT -> new DataContainer(type,
                    getInputData(type, InputParameter.SOURCE),
                    getInputData(type, InputParameter.DESTINATION),
                    getInputKey(type, InputParameter.KEY)
            );
            case BRUTE_FORCE -> new DataContainer(type,
                    getInputData(type, InputParameter.SOURCE),
                    getInputData(type, InputParameter.DESTINATION),
                    getInputData(type, InputParameter.DICTIONARY)
            );
        };
    }

    private String getInputData(Operation type, InputParameter parameter) {
        printMessage(parameter.getMessage(), parameter.getDefaultValue(type));

        String input = scanner.nextLine();
        return input.isEmpty() ? parameter.getDefaultValue(type) : input;
    }

    private int getInputKey(Operation type, InputParameter parameter) {
        String input = getInputData(type, parameter);
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new ApplicationException("invalid key = " + input, e);
        }
    }
}