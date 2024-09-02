package com.javarush.shirokova.util;

/**
 * Class for storing text messages used in the application.
 */
public class Messages {
    public static final String WELCOME_MESSAGE = "Welcome to the CryptoAnalizer Program!";
    public static final String FUNCTIONALITY_DESCRIPTION = "This program allows you to encrypt " +
            "and decrypt text files using a specified key.";

    public static final String MENU_OPTION_0 = "Exit";
    public static final String MENU_OPTION_1 = "Encrypt file";
    public static final String MENU_OPTION_2 = "Decrypt file";
    public static final String PROMPT_CHOICE = "Select an option: ";
    public static final String PROMPT_MENU = "List of available operations";

    public static final String EXIT_MESSAGE = "Exiting the application.";
    public static final String ENCRYPT_MESSAGE = "Encrypting file...";
    public static final String DECRYPT_MESSAGE = "Decrypting file...";

    public static final String PROMPT_INPUT_FILE = "Specify the input file path OR press enter to use the default path:  ";
    public static final String PROMPT_OUTPUT_FILE = "Specify the output file path OR press enter to use the default path: ";
    public static final String DEFAULT_INPUT_FILE_MESSAGE = "Using default input file: ";
    public static final String DEFAULT_OUTPUT_FILE_MESSAGE = "Using default output file: ";
    public static final String PROMPT_KEY = "Enter the encryption key: ";
    public static final String SUCCESS_ENCRYPT = "File successfully encrypted.";
    public static final String SUCCESS_DECRYPT = "File successfully decrypted.";

    public static final String ERROR_IO = "I/O error: ";
    public static final String ERROR_FORBIDDEN_FILE_PATH = "Error, path contains forbidden part: ";
    public static final String ERROR_PATH_IS_DIRECTORY = "The given path is a directory.";
    public static final String ERROR_FILE_DOES_NOT_EXIST = "The file with given path does not exist.";
    public static final String ERROR_FILE_IS_NOT_WRITABLE = "This file is not accessible for writing.";
    public static final String ERROR_FILE_IS_NOT_READABLE = "You do not have right to read this file.";
    public static final String ERROR_TRY_ENTER_PATH_AGAIN = "Try to enter the path again.";

    public static final String ERROR_INVALID_KEY = "Invalid key format. Please enter a number.";
    public static final String ERROR_INVALID_CHOICE = "Invalid choice. Please try again.";
    public static final String ERROR_INVALID_CHOICE_NOT_NUMBER = "It's not a number.";
}