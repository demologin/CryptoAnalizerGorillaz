package com.javarush.zubakha;

import java.util.Scanner;

import static com.javarush.zubakha.Cipher.decrypt;
import static com.javarush.zubakha.Cipher.encrypt;

public class RunApp {

    public static void main (String[] args) {

        System.out.println("Caesar's Cipher welcomes you!");

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Select the operating mode:");
            System.out.println("1 - Encryption");
            System.out.println("2 - Decipher");
            System.out.println("3 - Exit");

            int userSelected = scanner.nextInt();
            switch (userSelected) {
                case 1:
                    encrypt();
                    System.out.println("The text is encrypted.");
                    break;
                case 2:
                    decrypt();
                    System.out.println("The text has been decrypted.");
                    break;
                case 3:
                    System.out.println("See you later!");
                    System.exit(0);
                default:
                    System.out.println("There is no such mode. Try again.");
                    break;
            }


        }
    }
}
