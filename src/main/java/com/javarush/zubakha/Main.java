package com.javarush.zubakha;

import java.util.Scanner;

import static com.javarush.zubakha.Cipher.decrypt;
import static com.javarush.zubakha.Cipher.encrypt;

public class Main {
    public static void main (String[] args) {

        System.out.println("Шифр Цезаря приветствует вас!");

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Выберите режим работы:");
            System.out.println("1 - Шифрование");
            System.out.println("2 - Расшифровка");
            System.out.println("3 - Выход");

            int userSelected = scanner.nextInt();
            switch (userSelected) {
                case 1:
                    encrypt();
                    System.out.println("Текст зашифрован.");
                    break;
                case 2:
                    decrypt();
                    System.out.println("Текст расшифрован.");
                    break;
                case 3:
                    System.out.println("Увидимся позже!");
                    System.exit(0);
                default:
                    System.out.println("Такого режима нет. Попробуйте снова.");
                    break;
            }


        }
    }
}
