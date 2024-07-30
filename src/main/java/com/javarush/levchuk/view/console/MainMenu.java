package com.javarush.levchuk.view.console;

import com.javarush.levchuk.view.ProgramMessages;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.javarush.levchuk.constant.UtilConstants.ERROR_MESSAGES;
import static com.javarush.levchuk.constant.UtilConstants.TEXT_MAIN_MENU;
import static com.javarush.levchuk.controller.Controller.*;


public class MainMenu {
    public ProgramMessages consoleMessages;

    public MainMenu(ProgramMessages consoleMessages) {
        this.consoleMessages = consoleMessages;
    }

    public void printMainMenu() {
        String input = "";
        do {
            try {
                consoleMessages.printMessage(TEXT_MAIN_MENU);
                Scanner scanner = new Scanner(System.in);
                input = scanner.nextLine();
                switch (input) {
                    case "1" -> getEncode().runEncode();
                    case "2" -> getDecode().runDecode();
                    case "3" -> getBruteForce().runBruteForce();
                    case "4" -> consoleMessages.printMessage("Exit\n");
                    default -> consoleMessages.errorMessage(ERROR_MESSAGES[1]);
                }
            } catch (InputMismatchException e) {
                consoleMessages.errorMessage(ERROR_MESSAGES[1]);
            }
        } while (!input.equals("4"));

    }

}



