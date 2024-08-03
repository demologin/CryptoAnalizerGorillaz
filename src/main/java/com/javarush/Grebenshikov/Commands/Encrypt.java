package com.javarush.Grebenshikov.Commands;

import java.io.*;

import static com.javarush.Grebenshikov.constants.Constants.ALPHABET;
import static com.javarush.Grebenshikov.constants.Constants.ALPHABET_MAP;


public class Encrypt {
    public static void encrypt(String inputFile, String outputFile, int key) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                StringBuilder encryptedLine = new StringBuilder();
                for (char c : line.toLowerCase().toCharArray()) {
                    if (ALPHABET_MAP.containsKey(c)) {
                        int position = ALPHABET_MAP.get(c);
                        int newPosition = (position + key) % ALPHABET.length();
                        char encryptedChar = ALPHABET.charAt(newPosition);
                        encryptedLine.append(encryptedChar);
                    } else {
                        encryptedLine.append(c);
                    }
                }
                writer.write(encryptedLine.toString());
                writer.newLine();
            }
        }
    }
    }
        

