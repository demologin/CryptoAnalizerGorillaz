package com.javarush.levchuk.view.console;

import com.javarush.levchuk.view.ProgramMessages;

public class ConsolePrinter extends ProgramMessages {
    @Override
    public void printMessage(String message) {
        System.out.print(message);
    }

    @Override
    public void errorMessage(String message) {
         System.err.println(message);
    }

    @Override
    public void printfMessage(String contextMessage, String... message) {
        System.out.printf(contextMessage, message);
    }
}
