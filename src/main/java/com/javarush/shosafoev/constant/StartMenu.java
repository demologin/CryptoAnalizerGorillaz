package com.javarush.shosafoev.constant;

import java.util.Scanner;

public class StartMenu {
    private final DataInputOutput data;

    public StartMenu() {
        data = new DataInputOutput();
    }

    public void run() {
        while (true) {
            System.out.println("*** MENU OF PROJECT: encoding/decoding files by Caesar's cipher ***");
            System.out.println("******** please choose item (from 1 to 2 ****************)");
            System.out.println("1. Encoding of file");
            System.out.println("2. Decoding of file");
            System.out.println("other key. EXIT");
            System.out.println("----------");
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextLine()) {
                case "1" -> data.dataInputOutput("1");
                case "2" -> data.dataInputOutput("2");
                default -> {
                    System.out.println("game over");
                    System.exit(0);
                }
            }
        }
    }
}
