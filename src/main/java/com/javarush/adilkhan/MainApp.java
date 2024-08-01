package com.javarush.adilkhan;

import java.io.IOException;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cipher cipher = new Cipher();

        System.out.println("Выберите действие:");
        System.out.println("""
                1. Шифрование
                2. Расшифровка с ключом
                0. Выход""");

        int userNumber = scanner.nextInt();
        if(userNumber == 1) {
            System.out.println("Введите название файла для чтения:");
            String inputFileName = scanner.nextLine();

            System.out.println("Введите название файла для записи:");
            String outputFileName = scanner.nextLine();

            System.out.println("Введите ключ для шифрования:");
            int keyValue = scanner.nextInt();

            try {
                cipher.encrypt(inputFileName, outputFileName, keyValue);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (userNumber == 2) {

        }
    }
}
