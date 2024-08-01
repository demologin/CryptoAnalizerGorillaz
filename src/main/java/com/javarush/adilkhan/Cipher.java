package com.javarush.adilkhan;

import com.javarush.adilkhan.utils.Alphabet;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Cipher {

    public void encrypt(String inputFile, String outputFile, int key) throws IOException {
        Path from = Paths.get(inputFile);

        byte[] bytes = Files.readAllBytes(from);
        String textFile = new String(bytes, StandardCharsets.UTF_8);

        try (FileWriter writer = new FileWriter(outputFile)) {

            for (int i = 0; i < textFile.length(); i++) {
                char characterOfFile = textFile.charAt(i);
                characterOfFile = Character.toLowerCase(characterOfFile);
                if (Alphabet.characterSet.contains(characterOfFile)) {
                    int baseIndex = Alphabet.characterSet.get(characterOfFile);
                    baseIndex = ((baseIndex + key) % Alphabet.characterSet.size());
                    writer.write(Alphabet.characterSet.get(baseIndex));
                } else {
                    writer.write(characterOfFile);
                }
            }
        }
    }
}
