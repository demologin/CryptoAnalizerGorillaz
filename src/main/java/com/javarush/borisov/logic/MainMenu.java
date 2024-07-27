package com.javarush.borisov.logic;

import java.nio.file.Path;
import java.util.Scanner;

public  class MainMenu {

    private final Scanner  scan;

    public MainMenu(Scanner scan){
        this.scan=scan;
    }
    public  int getCommand(){
        System.out.println(Messages.GREETINGS);
        Scanner scan = new Scanner(System.in);
        System.out.println(Messages.MENU_ENCODE);
        System.out.println(Messages.MENU_DECODE);
        System.out.println(Messages.MENU_BRUT_FORCE);
        System.out.println(Messages.MENU_EXIT);
        int choice;
        while(true) {
            try {
                choice = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ведите число!");
                continue;
            }
            break;
        }
        return choice;

    }
    public  Path getPathToGetFile(){
        System.out.println(Messages.ENTER_PATH_TO_FILE);
        return Path.of(scan.nextLine());
    }
    public int getKey(){
        System.out.println(Messages.ENTER_KEY);
        String line = scan.nextLine();
        try {
            return Integer.parseInt(line);
        }catch (Exception e) {
            return line.length();
        }
    }
    public Path getPathToSaveFile(){
        System.out.println(Messages.ENTER_PATH_TI_SAVE);


        return Path.of(scan.nextLine());
    }


}
