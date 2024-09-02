package com.javarush.Grebenshikov;

import java.io.IOException;
import java.util.Scanner;


import static com.javarush.Grebenshikov.Commands.Decrypt.decrypt;
import static com.javarush.Grebenshikov.Commands.Encrypt.encrypt;




public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Caesar Cipher Menu:");
        System.out.println("1. Encrypt");
        System.out.println("2. Decrypt");
        System.out.println("3. Exit");
        System.out.print("Make your choice: ");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                System.out.print("Enter the path for the source file: ");
                String inputFile = scanner.next();
                System.out.print("Enter the path of the destination file: ");
                String outputFile = scanner.next();
                System.out.print("Enter key: ");
                int key = scanner.nextInt();
                try {
                    encrypt(inputFile, outputFile, key);
                    System.out.println("Encryption completed successfully!)");
                } catch (IOException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;
            case 2:
                System.out.print("Enter the path for the source file: ");
                inputFile = scanner.next();
                System.out.print("Enter the path of the destination file: ");
                outputFile = scanner.next();
                System.out.print("Enter key: ");
                key = scanner.nextInt();
                try {
                    decrypt(inputFile, outputFile, key);
                    System.out.println("Decryption completed successfully!)");
                } catch (IOException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;
            case 3:
                System.out.println("Bye bye");
                break;
            default:
                System.out.println("Wrong option");
        }
    }

}
