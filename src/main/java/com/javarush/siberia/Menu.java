package com.javarush.siberia;

import com.javarush.siberia.constants.Constants;

import java.util.Scanner;

public class Menu {

    private final Application application;

    public Menu(Application application) {
        this.application = application;
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(Constants.MENU);

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    toEncode(scanner);
                    break;

                case "2":
                    toDecode(scanner);
                    break;

                case "3":
                    toBruteForce(scanner);
                    break;

                case "4":
                    toAnalyse(scanner);
                    break;

                case "5":
                    System.out.println(Constants.EXIT_MESSAGE);
                    return;

                default:
                    System.out.println(Constants.INVALID_CHOICE);
            }
        }
    }

    private void toEncode(Scanner scanner) {

    }

    private void toDecode(Scanner scanner) {

    }

    private void toBruteForce(Scanner scanner) {

    }

    private void toAnalyse(Scanner scanner) {

    }


}
