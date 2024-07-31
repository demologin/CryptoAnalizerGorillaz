package com.javarush.adilkhan;

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
            String inputFileName = scanner.nextLine();
            String outputFileName = scanner.nextLine();
            int keyValue = scanner.nextInt();
//            cipher.encrypt(inputFileName, outputFileName, keyValue);
        } else if (userNumber == 2) {

        }
    }
}
