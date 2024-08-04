package com.javarush.nikitin;

import com.javarush.nikitin.controllers.DataController;
import com.javarush.nikitin.view.ConsoleApplication;
import com.javarush.nikitin.view.InteractiveMenu;

import java.util.Scanner;

public class ConsoleRun {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        InteractiveMenu interactiveMenu = new InteractiveMenu(scanner);
        DataController mainController = new DataController();
        ConsoleApplication app = new ConsoleApplication(interactiveMenu, mainController);

        app.initialize();
        scanner.close();

    }
}


