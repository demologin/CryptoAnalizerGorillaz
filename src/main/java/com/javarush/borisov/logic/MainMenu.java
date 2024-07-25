package com.javarush.borisov.logic;

import java.nio.file.Path;
import java.util.Scanner;

public  class MainMenu {

    private final Scanner  scan;
    private int choice=0;

    public MainMenu(Scanner scan){
        this.scan=scan;
    }
    public  int getCommand(){
        System.out.println(Messages.GREETINGS);
        Scanner scan = new Scanner(System.in);
        System.out.println(Messages.MENU_ENCODE);
        System.out.println(Messages.MENU_DECODE);
        System.out.println(Messages.MENU_EXIT);
        while(true) {
            try {
                choice = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ведите число!");
            }
            break;
        }
        return choice;

    }
    public  Path getPathToGetFile(){
        System.out.println("введите путь к файлу: ");
        return Path.of(scan.nextLine());
    }
    public int getKey(){
        System.out.println("введите фразу для шифра: ");

        return scan.nextLine().length();
    }
    public Path getPathToSaveFile(){
        System.out.println("введите место сохранения файла ");


        return Path.of(scan.nextLine());
    }


}
