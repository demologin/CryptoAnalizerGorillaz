package com.javarush.levchuk.view.console;

import com.javarush.levchuk.controller.Controller;
import com.javarush.levchuk.exceptions.AppException;
import com.javarush.levchuk.abstractions.ProgramMessages;

import java.util.Scanner;

import static com.javarush.levchuk.constant.UtilConstants.*;


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
                consoleMessages.printMessage(ANSI_GREEN + TEXT_MAIN_MENU + ANSI_RESET);
                Scanner scanner = new Scanner(System.in);
                input = scanner.nextLine();
                switch (input) {
                    case "1" -> controller.getEncode().runEncode();
                    case "2" -> controller.getDecode().runDecode();
                    case "3" -> controller.getBruteForce().runBruteForce();
                    case "4" -> consoleMessages.printMessage(ANSI_YELLOW + CONTEXT_MESSAGES[4] + ANSI_RESET);
                    default -> consoleMessages.errorMessage(ERROR_MESSAGES[1]);
                }
            } catch (AppException e) {
                consoleMessages.errorMessage(e.getMessage());
            }
        } while (!input.equals("4"));

    }

}



