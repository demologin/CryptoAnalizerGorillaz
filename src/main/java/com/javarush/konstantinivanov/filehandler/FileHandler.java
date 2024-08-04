package com.javarush.konstantinivanov.filehandler;

import com.javarush.konstantinivanov.constant.Alphabet;

import com.javarush.konstantinivanov.exception.AppException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileHandler {
    public static File source = new File("src/main/java/com/javarush/konstantinivanov/file/source.txt");
    public static File result = new File("src/main/java/com/javarush/konstantinivanov/file/result.txt");
    public static File decoded = new File("src/main/java/com/javarush/konstantinivanov/file/decoded.txt");

    public static File getSource() {
        return source;
    }

    public static File getResult() {
        return result;
    }

    public static File getDecoded() {
        return decoded;
    }

    public void copyWithKey(String sourceTextFile, String targetTextFile, int key) {
        Path source = Path.of(sourceTextFile);
        Path target = Path.of(targetTextFile);
        try (BufferedReader reader = Files.newBufferedReader(source);
             BufferedWriter writer = Files.newBufferedWriter(target)) {

            int value;
            while ((value = reader.read()) > -1) {
                char character = (char) value;
                character = Character.toLowerCase(character);

                if (Alphabet.index.containsKey(character)) {
                    Integer index = Alphabet.index.get(character);
                    index = (index + key + Math.abs(key) * Alphabet.CHARS.length) % Alphabet.CHARS.length;
                    writer.write(Alphabet.CHARS[index]);
                } else if (character == '\n') {
                    writer.write(character);
                }
            }
        } catch (IOException e) {
            throw new AppException(e);
        }
    }

}
