package com.javarush.adilkhan;

import com.javarush.adilkhan.utils.Alphabet;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Cipher {

    public void encrypt(String inputFile, String outputFile, int key) throws IOException {
        Path path = Paths.get(inputFile);
        InputStream inputStream = Files.newInputStream(path);

        Alphabet alphabet = new Alphabet();
        alphabet.alphabetLetterCheck(inputStream);
    }
}
