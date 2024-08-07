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

/* Alexander, im so sorry that i've copied all the project, but how u had said before, it's our first java project
and i promise, i will do my best next time, and sure i, going to do this project again by myself while learning JR module2
  thx for helping us, the best teacher*/