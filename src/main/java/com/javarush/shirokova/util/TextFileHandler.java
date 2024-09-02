package com.javarush.shirokova.util;

import com.javarush.shirokova.service.FileHandler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Class provides methods for reading and writing text files.
 * It implements the FileHandler interface.
 */
public class TextFileHandler implements FileHandler {

    /**
     * Reads the content of a text file and returns it as a String.
     *
     * @param filePath the path to the file to be read.
     * @return the content of the file as a String.
     * @throws IOException if an I/O error occurs while reading the file.
     */
    @Override
    public String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
        }
        return content.toString();
    }

    /**
     * Writes the given content to a specified text file.
     *
     * @param filePath the path to the file where content will be written.
     * @param content  the content to write to the file.
     * @throws IOException if an I/O error occurs while writing to the file.
     */
    @Override
    public void writeFile(String filePath, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        }
    }
}