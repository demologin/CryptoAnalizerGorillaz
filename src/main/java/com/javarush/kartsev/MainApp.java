package com.javarush.kartsev;

import com.javarush.kartsev.console.ConsoleApp;
import com.javarush.kartsev.console.Menu;
import com.javarush.kartsev.controllers.MainController;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        //here we start console app
        Scanner input = new Scanner(System.in);
        Menu menu = new Menu(input);
        MainController mainController = new MainController();
        ConsoleApp application = new ConsoleApp(mainController,menu);

        application.run(args);

    }
}

