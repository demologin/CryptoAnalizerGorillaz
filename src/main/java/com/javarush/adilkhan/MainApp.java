package com.javarush.adilkhan;

import java.io.IOException;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cypher cypher = new Cypher();

        final String FILE_NAME_FOR_READING = "Введите название файла для чтения:";
        final String FILE_NAME_FOR_WRITNG = "Введите название файла для записи:";
        final String KEY_FOR_CYPHER = "Введите ключ для шифрования:";
        String userNumber;

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("""
                    1. Шифрование
                    2. Расшифровка с ключом
                    0. Выход""");

            userNumber = scanner.nextLine();
            if (userNumber.equalsIgnoreCase("exit")) {
                break;
            }

            int userNumber1 = Integer.parseInt(userNumber);

            if (userNumber1 == 1) {
                System.out.println(FILE_NAME_FOR_READING);
                String inputFileName = scanner.nextLine();

                System.out.println(FILE_NAME_FOR_WRITNG);
                String outputFileName = scanner.nextLine();

                System.out.println(KEY_FOR_CYPHER);
                int keyValue = scanner.nextInt();

                try {
                    cypher.encrypt(inputFileName, outputFileName, keyValue);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else if (userNumber1 == 2) {
                System.out.println(FILE_NAME_FOR_READING);
                String inputFileName = scanner.nextLine();

                System.out.println(FILE_NAME_FOR_WRITNG);
                String outputFileName = scanner.nextLine();

                System.out.println(KEY_FOR_CYPHER);
                int keyValue = scanner.nextInt();

                try {
                    cypher.decrypt(inputFileName, outputFileName, keyValue);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else if (userNumber1 == 0) {
                break;
            }
        }
    }
}
