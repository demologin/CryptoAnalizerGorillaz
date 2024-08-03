package com.javarush.shosafoev.controllers;

import com.javarush.shosafoev.exceptions.FileReadException;
import com.javarush.shosafoev.exceptions.FileWriteException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Logger;

import static java.lang.StringTemplate.STR;

public class File {
    private static final Logger logger = Logger.getLogger("FileManager logger");

    /**
     * Read data from file
     *
     * @param filePath path of file
     * @return readed data in string
     */
    public String readFile(String filePath) {
        int counter = 1;
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(Path.of(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
                counter++;
            }
        } catch (IOException e) {
            logger.warning((STR."String \{counter} in file \{filePath} hasn't read!"));
            throw new FileReadException("Error reading of file");
        }
        return builder.toString();
    }

    /**
     * Write data to file
     *
     * @param content data to write
     * @param filePath path of file
     */
    public void writeFile(String content, String filePath) {
        Map validator = new Map();
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of(filePath))) {
            if (!validator.isFileExists(filePath)) {
                Files.createFile(Path.of(filePath));
            }
            writer.write(content);
        } catch (IOException e) {
            throw new FileWriteException("Error writing of file");
        }
    }
}
