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
            String entry = scan.nextLine();

            try {
                choice = Integer.parseInt(entry);
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
        String path = scan.nextLine();
        if (path.isEmpty()){
            Path tmp = Path.of((Thread.currentThread().getStackTrace()[1].getClassName()));
            tmp = tmp.relativize(Path.of("borisov/files/text.txt")).toAbsolutePath().normalize();
            return tmp;

        }

        return Path.of(path);
    }

    public  Path getPathToGetFile(int a){
        System.out.println(Messages.ENTER_PATH_TO_FILE);
        String path = scan.nextLine();
        if (path.isEmpty()){
            Path tmp = Path.of((Thread.currentThread().getStackTrace()[1].getClassName()));
            tmp = tmp.relativize(Path.of("borisov/files/encrypted.txt")).toAbsolutePath().normalize();
            return tmp;

        }

        return Path.of(path);
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
        System.out.println(Messages.ENTER_PATH_TO_SAVE);
        String path = scan.nextLine();
        if (path.isEmpty()){
            Path tmp = Path.of((Thread.currentThread().getStackTrace()[1].getClassName()));
            tmp = tmp.relativize(Path.of("borisov/files/encrypted.txt")).toAbsolutePath().normalize();
            return tmp;

        }


        return Path.of(path);
    }
    public Path getPathToSaveFile(int a){
        System.out.println(Messages.ENTER_PATH_TO_SAVE);
        String path = scan.nextLine();
        if (path.isEmpty()){
            Path tmp = Path.of((Thread.currentThread().getStackTrace()[1].getClassName()));
            tmp = tmp.relativize(Path.of("borisov/files/decrypted.txt")).toAbsolutePath().normalize();
            return tmp;

        }


        return Path.of(path);
    }


}
