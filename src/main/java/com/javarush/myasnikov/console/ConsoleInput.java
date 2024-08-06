package com.javarush.myasnikov.console;


import java.util.Scanner;


public class ConsoleInput {
    public int enterConsoleNumber() {
        int consoleMenuOptionSelected;
        while (true) {
            try {
                var scanner = new Scanner(System.in);
                consoleMenuOptionSelected = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("You've entered an invalid option.");
            }
        }
        return consoleMenuOptionSelected;
    }

    public String enterConsoleText() {
        String consoleText;
        var scanner = new Scanner(System.in);
        consoleText = scanner.nextLine();
        return consoleText;
    }
}
