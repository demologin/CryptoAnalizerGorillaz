package com.javarush.zubakha;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Cipher {
    private static final String letters = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private static final String numbers = "0123456789";
    private static final String symbols = ".,\"^-!& \n";
    static final String ALPHABET = letters + letters.toUpperCase() + numbers + symbols;



    public static void encrypt() {
        try  {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the path to the source file");
            Path fileInputStream = Path.of(scanner.nextLine());
            while (!Files.exists(fileInputStream)){
                System.out.println("The file does not exist.\nEnter the path to the source file.");
                fileInputStream = Path.of(scanner.nextLine());
            }
            System.out.println("Enter the path to the file to write to");
            Path fileOutputStream = Path.of(scanner.nextLine());
            System.out.println("Enter the key");
            int key = scanner.nextInt();
            if (key > ALPHABET.length()) {
                key = key % ALPHABET.length();
            } else if (key < 0) {
                key = (key % ALPHABET.length()) + ALPHABET.length();
            }
            try (BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(fileInputStream)));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(String.valueOf(fileOutputStream)))) {
                StringBuilder builder = new StringBuilder();
                while (reader.ready()) {
                    String readLine = reader.readLine();
                    char readCh;
                    for (int i = 0; i < readLine.length(); i++) {
                        readCh = readLine.charAt(i);
                        if (ALPHABET.indexOf(readCh) != -1) {
                            readCh = ALPHABET.charAt((ALPHABET.indexOf(readCh) + key) % ALPHABET.length());
                        }
                        builder.append(readCh);
                    }
                }
                writer.write(String.valueOf(builder), 0, builder.length());
            }
        } catch (IOException | RuntimeException e) {
            System.out.println("Something went wrong : " + e);
        }
    }



    public static void decrypt() {
        try  {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the path to the source file");
            Path fileInputStream = Path.of(scanner.nextLine());
            while (!Files.exists(fileInputStream)){
                System.out.println("The file does not exist.\nEnter the path to the source file.");
                fileInputStream = Path.of(scanner.nextLine());
            }
            System.out.println("Enter the path to the file to write to");
            Path fileOutputStream = Path.of(scanner.nextLine());
            System.out.println("Enter the key");
            int key = scanner.nextInt();
            if (key > ALPHABET.length()) {
                key = key % ALPHABET.length();
            } else if (key < 0) {
                key = (key % ALPHABET.length()) + ALPHABET.length();
            }
            try (BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(fileInputStream)));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(String.valueOf(fileOutputStream)))) {
                StringBuilder builder = new StringBuilder();
                while (reader.ready()) {
                    String readLine = reader.readLine();
                    char readCh;
                    for (int i = 0; i < readLine.length(); i++) {
                        readCh = readLine.charAt(i);
                        if (ALPHABET.indexOf(readCh) != -1) {
                            if(ALPHABET.indexOf(readCh) - key >= 0){
                                readCh = ALPHABET.charAt((ALPHABET.indexOf(readCh) - key) % ALPHABET.length());
                            }
                            else {
                                readCh = ALPHABET.charAt(ALPHABET.length() + (ALPHABET.indexOf(readCh) - key) % ALPHABET.length());
                            }
                        }
                        builder.append(readCh);
                    }
                }
                writer.write(String.valueOf(builder), 0, builder.length());
            }
        } catch (IOException | RuntimeException e) {
            System.out.println("Something went wrong : " + e);
        }
    }
}
