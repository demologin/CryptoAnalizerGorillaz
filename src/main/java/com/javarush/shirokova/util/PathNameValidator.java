package com.javarush.shirokova.util;

import com.javarush.shirokova.view.UserInterface;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Validates file paths to ensure they are allowable for reading and writing operations.
 */
public class PathNameValidator {
    private static final List<String> FORBIDDEN_DIRS_FILES =
            List.of(".bash_history", ".bash_profile", "etc", "proc", "System32"); // system folders
    public static final String SYSTEM_SEPARATOR = FileSystems.getDefault().getSeparator();
    public static String TXT_FOLDER = System.getProperty("user.dir") +
            SYSTEM_SEPARATOR + "text" + SYSTEM_SEPARATOR;
    public static String DEFAULT_INPUT_FILE_PATH = TXT_FOLDER + "text.txt";
    public static String DEFAULT_ENCRYPTED_FILE_PATH = TXT_FOLDER + "encrypted.txt";
    public static String DEFAULT_DECRYPTED_FILE_PATH = TXT_FOLDER + "decrypted.txt";

    private final UserInterface userInterface;

    public PathNameValidator(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    /**
     * Checks if the specified file path contains forbidden directories or filenames.
     *
     * @param filepath the path of the file to validate
     * @return true if the path is not forbidden; false otherwise
     */
    public boolean isFilePathForbidden(String filepath) {
        boolean valid = true;
        String[] pathParts = filepath.split(Pattern.quote(SYSTEM_SEPARATOR));

        for (String pathPart : pathParts) {
            if (FORBIDDEN_DIRS_FILES.contains(pathPart)) {
                userInterface.showMessage(Messages.ERROR_FORBIDDEN_FILE_PATH + pathPart);
                valid = false;
                break;
            }
        }
        return valid;
    }

    /**
     * Validates if the specified path is suitable for writing.
     *
     * @param filepath the path of the file to validate
     * @return true if the path is valid for writing; false otherwise
     */
    public boolean isPathValidForWriting(String filepath) {
        boolean valid = true;
        Path path = Path.of(filepath);
        userInterface.showMessage("Validating path: " + filepath); // Отладочная информация

        if (Files.isDirectory(path)) {
            valid = false;
            userInterface.showMessage(Messages.ERROR_PATH_IS_DIRECTORY);
        } else if (isFilePathForbidden(filepath)) {
            valid = false;
        } else if (!Files.isWritable(path)) {
            valid = false;
            userInterface.showMessage(Messages.ERROR_FILE_IS_NOT_WRITABLE);
        }
        return valid;
    }

    /**
     * Validates if the specified path is suitable for reading.
     *
     * @param filepath the path of the file to validate
     * @return true if the path is valid for reading; false otherwise
     */
    public boolean isPathValidForReading(String filepath) {
        boolean valid = true;
        Path path = Path.of(filepath);
        userInterface.showMessage("Validating path: " + filepath); // Отладочная информация

        if (Files.notExists(path)) {
            valid = false;
            userInterface.showMessage(Messages.ERROR_FILE_DOES_NOT_EXIST);
        } else if (Files.isDirectory(path)) {
            valid = false;
            userInterface.showMessage(Messages.ERROR_PATH_IS_DIRECTORY);
        } else if (isFilePathForbidden(filepath)) {
            valid = false;
        } else if (!Files.isReadable(path)) {
            valid = false;
            userInterface.showMessage(Messages.ERROR_FILE_IS_NOT_READABLE);
        }
        return valid;
    }

    /**
     * Gets the default path based on encryption status and read/write intent.
     *
     * <p>This method returns different default file paths depending on whether the operation
     * is for reading or writing and whether it involves encryption or decryption.</p>
     *
     * @param isEncryption indicates if the operation is for encryption (true) or decryption (false).
     * @param isForReading indicates if the path is for reading (true) or writing (false).
     * @return the default file path depending on the operation type. For encryption and reading,
     *         returns the path for the input file. For decryption and reading, returns the path
     *         for the encrypted file. For writing, returns the path for the output file based
     *         on the operation type.
     */
    public String getDefaultPath(boolean isEncryption, boolean isForReading) {
        String filePath;
        if (isForReading) {
            filePath = isEncryption
                    ? PathNameValidator.DEFAULT_INPUT_FILE_PATH // default input for encryption (text.txt)
                    : PathNameValidator.DEFAULT_ENCRYPTED_FILE_PATH; // default input for decryption (encrypted.txt)
        } else {
            filePath = isEncryption
                    ? PathNameValidator.DEFAULT_ENCRYPTED_FILE_PATH // default output encrypted file (encrypted.txt)
                    : PathNameValidator.DEFAULT_DECRYPTED_FILE_PATH; // default output decrypted file (decrypted.txt)
        }
        return filePath;
    }
}