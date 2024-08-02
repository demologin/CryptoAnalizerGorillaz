package com.javarush.levchuk;


import com.javarush.levchuk.controller.Controller;
import com.javarush.levchuk.abstractions.ProgramMessages;
import com.javarush.levchuk.view.console.ConsolePrinter;
import com.javarush.levchuk.view.console.ConsoleMenu;

public class ConsoleRunner {
    public static void main(String[] args) {
        ProgramMessages consolePrinter = new ConsolePrinter();
        Controller controller = new Controller(consolePrinter);
        ConsoleMenu mainMenu = new ConsoleMenu(consolePrinter, controller);
        mainMenu.runApp();
    }
}