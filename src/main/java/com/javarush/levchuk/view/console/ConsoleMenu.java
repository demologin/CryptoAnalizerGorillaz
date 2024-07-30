package com.javarush.levchuk.view.console;

import com.javarush.levchuk.controller.Controller;
import com.javarush.levchuk.view.ProgramMessages;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.javarush.levchuk.constant.UtilConstants.ERROR_MESSAGES;
import static com.javarush.levchuk.constant.UtilConstants.TEXT_MAIN_MENU;


public class ConsoleMenu {
    public ProgramMessages consoleMessages;
    public Controller controller;

    public ConsoleMenu(ProgramMessages consoleMessages, Controller controller) {
        this.consoleMessages = consoleMessages;
        this.controller = controller;
    }

    public void runApp() {
        String input = "";
        do {
            try {
                consoleMessages.printMessage(TEXT_MAIN_MENU);
                Scanner scanner = new Scanner(System.in);
                input = scanner.nextLine();
                switch (input) {
                    case "1" -> controller.getEncode().runEncode();
                    case "2" -> controller.getDecode().runDecode();
                    case "3" -> controller.getBruteForce().runBruteForce();
                    case "4" -> consoleMessages.printMessage("Exit\n");
                    default -> consoleMessages.errorMessage(ERROR_MESSAGES[1]);
                }
            } catch (InputMismatchException e) {
                consoleMessages.errorMessage(ERROR_MESSAGES[1]);
            }
        } while (!input.equals("4"));

    }

}



