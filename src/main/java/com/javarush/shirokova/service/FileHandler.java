package com.javarush.shirokova.service;

import java.io.IOException;

/**
 * Interface for file handling.
 */
public interface FileHandler {
    /**
     * Reads the contents of a file.
     *
     * @param filePath Path to the input file.
     * @return Content of the file as a string.
     * @throws IOException If an error occurs while reading the file.
     */
    String readFile(String filePath) throws IOException;

    /**
     * Writes content to a file.
     *
     * @param filePath Path to the output file.
     * @param content  Content to write.
     * @throws IOException If an error occurs while writing to the file.
     */
    void writeFile(String filePath, String content) throws IOException;
}