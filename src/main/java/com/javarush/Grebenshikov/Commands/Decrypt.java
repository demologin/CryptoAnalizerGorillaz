package com.javarush.Grebenshikov.Commands;

import java.io.IOException;

import static com.javarush.Grebenshikov.Commands.Encrypt.encrypt;
import static com.javarush.Grebenshikov.constants.Constants.ALPHABET;

public class Decrypt {
    public static void decrypt(String inputFile, String outputFile, int key) throws IOException {
        encrypt(inputFile, outputFile, ALPHABET.length() - key);
    }
}
