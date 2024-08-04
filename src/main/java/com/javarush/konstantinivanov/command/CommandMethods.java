package com.javarush.konstantinivanov.command;

import com.javarush.konstantinivanov.filehandler.FileHandler;

import java.util.Scanner;

public class CommandMethods {

    public static boolean decode(Scanner input) {
        String sourceTextFile;
        String targetTextFile;
        System.out.println("Введите путь к файлу для декодирования:");
        System.out.println("(если хотите использовать файл result.txt нажмите 1)");
        if (input.nextLine().equals("1")) {
            sourceTextFile = String.valueOf(FileHandler.getResult());
        } else {
            sourceTextFile = input.nextLine();
        }
        System.out.println("Введите путь к файлу для сохранения результата");
        System.out.println("(если хотите использовать файл decoded.txt нажмите 1)");
        if (input.nextLine().equals("1")){
            targetTextFile = String.valueOf(FileHandler.getDecoded());
        } else {
            targetTextFile = input.nextLine();
        }
        System.out.println("Введите ключ для декодирования");
        String code = input.nextLine();
        FileHandler fileHandler = new FileHandler();
        fileHandler.copyWithKey(sourceTextFile, targetTextFile, Integer.parseInt(code) * -1);
        System.out.println("Код раскодирован");
        return true;
    }

    public static boolean encode(Scanner input) {
        String sourceTextFile;
        String targetTextFile;
        System.out.println("Введите путь к файлу для кодирования:");
        System.out.println("(если хотите использовать файл source.txt нажмите 1)");
        if (input.nextLine().equals("1")) {
            sourceTextFile = String.valueOf(FileHandler.getSource());
        } else {
            sourceTextFile = input.nextLine();
        }
        System.out.println("Введите путь к файлу для сохранения результата");
        System.out.println("(если хотите использовать файл result.txt нажмите 1)");
        if (input.nextLine().equals("1")){
            targetTextFile = String.valueOf(FileHandler.getResult());
        } else {
            targetTextFile = input.nextLine();
        }
        System.out.println("Введите ключ для кодирования");
        String code = input.nextLine();
        FileHandler fileHandler = new FileHandler();
        fileHandler.copyWithKey(sourceTextFile, targetTextFile, Integer.parseInt(code));
        System.out.println("Код закодирован");
        return true;
    }

    public static void exit(Scanner input) {
        System.out.println("Программа завершила работу");
    }

}
