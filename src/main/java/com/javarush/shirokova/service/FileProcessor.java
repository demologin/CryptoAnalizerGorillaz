package com.javarush.shirokova.service;

import com.javarush.shirokova.util.Messages;
import com.javarush.shirokova.model.Cipher;

import java.io.IOException;

/**
 * Class for processing files with encryption and decryption.
 */
public class FileProcessor {
    private final FileHandler fileHandler;
    private final Cipher cipher;

    /**
     * Constructor for creating a FileProcessor instance.
     *
     * @param fileHandler Object implementing FileHandler for file operations.
     * @param cipher      Object implementing Cipher for encryption/decryption.
     */
    public FileProcessor(FileHandler fileHandler, Cipher cipher) {
        this.fileHandler = fileHandler;
        this.cipher = cipher;
    }

    /**
     * Processes a file by encrypting or decrypting its content.
     *
     * @param inputFile  Path to the input file.
     * @param outputFile Path to the output file.
     * @param key        Key for encryption/decryption.
     * @param encrypt    Flag indicating whether to perform encryption (true) or decryption (false).
     */
    public void processFile(String inputFile, String outputFile, int key, boolean encrypt) {
        try {
            String content = fileHandler.readFile(inputFile);
            String processedContent = encrypt ? cipher.encrypt(content, key) : cipher.decrypt(content, key);
            fileHandler.writeFile(outputFile, processedContent);
            System.out.println(encrypt ? Messages.SUCCESS_ENCRYPT : Messages.SUCCESS_DECRYPT);
        } catch (IOException e) {
            System.err.println(Messages.ERROR_IO + e.getMessage());
        }
    }
}