package com.javarush.borisov.logic;

import java.nio.file.Path;
import java.util.Scanner;

public  class MainMenu {

    private final Scanner  scan;


    public MainMenu(Scanner scan){
        this.scan=scan;
    }
    public  int getCommand(){
        System.out.println("Выберете действие");
        Scanner scan = new Scanner(System.in);
        System.out.println("1 - зашифровать");
        System.out.println("2 - расшифровать");
        System.out.println("3 - вычислить ключ");
        int choice = Integer.parseInt(scan.nextLine());
        return choice;

    }
    public  Path getPathToGetFile(){
        System.out.println("введите путь к файлу: ");
        Path pathOfFile = Path.of(scan.nextLine());
        return pathOfFile;
    }
    public int getKey(){
        System.out.println("введите фразу для шифра: ");

        return scan.nextLine().length();
    }
    public Path getPathToSaveFile(){
        System.out.println("введите место сохранения файла ");

        Path pathToEncryptedFile = Path.of(scan.nextLine());
        return pathToEncryptedFile;
    }


}
