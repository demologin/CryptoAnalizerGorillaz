package com.javarush.levchuk;


import com.javarush.levchuk.controller.Controller;
import com.javarush.levchuk.view.ProgramMessages;
import com.javarush.levchuk.view.console.ConsolePrinter;
import com.javarush.levchuk.view.console.MainMenu;

public class ConsoleRunner {
    public static void main(String[] args) {
        ProgramMessages consolePrinter = new ConsolePrinter();
        Controller controller = new Controller(consolePrinter);
        MainMenu mainMenu = new MainMenu(consolePrinter, controller);
        mainMenu.printMainMenu();
    }
}