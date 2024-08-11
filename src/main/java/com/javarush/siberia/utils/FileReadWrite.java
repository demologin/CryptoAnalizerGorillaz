package com.javarush.siberia.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReadWrite {

    public static char[] readFile(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName))).toCharArray();
    }

    public static void writeFile(String fileName, char[] content) throws IOException {
        Files.write(Paths.get(fileName), new String(content).getBytes());
    }
}