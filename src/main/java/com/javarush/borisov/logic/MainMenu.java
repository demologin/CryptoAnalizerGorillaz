package com.javarush.borisov.logic;

import java.nio.file.Path;
import java.util.Scanner;

public  class MainMenu {
    private Path pathOfFile;
    private Path pathToEncryptedFile;
    private int key;
    private Scanner scan;


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
    public  Path getPathOfFile(){
        System.out.println("введите путь к файлу: ");
        pathOfFile = Path.of(scan.nextLine());
        return pathOfFile;
    }
    public int getKey(){
        System.out.println("введите фразу для шифра: ");

        return scan.nextLine().length();
    }
    public Path getPathToEncryptedFile(){
        System.out.println("введите место сохранения файла ");

        pathToEncryptedFile = Path.of(scan.nextLine());
        return pathToEncryptedFile;
    }

}
