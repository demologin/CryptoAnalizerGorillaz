package com.javarush.levchuk.view.console;

import com.javarush.levchuk.view.ProgramMessages;

public class ConsolePrinter extends ProgramMessages {
    @Override
    public void printMessage(String message) {
        System.out.printf(message);
    }

    @Override
    public void errorMessage(String message) {
         System.err.println(message);
    }
}
