package com.javarush.borisov;


import com.javarush.borisov.logic.MainMenu;
import com.javarush.borisov.logic.Runner;


import java.util.Scanner;

public class console { public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        MainMenu menu = new MainMenu(scan);
        Runner runner = new Runner();

        runner.run(menu);




    }
}
