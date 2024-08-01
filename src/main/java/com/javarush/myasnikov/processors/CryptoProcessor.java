package com.javarush.myasnikov.processors;
import com.javarush.myasnikov.inputs.FileHandler;
import com.javarush.myasnikov.utilities.Command;

import java.io.File;

import static com.javarush.myasnikov.utilities.Command.*;

public class CryptoProcessor {

    private String outputMessage;
    private final FileHandler fileHandler = new FileHandler();

    public CryptoProcessor(String alphabet, String inputMessage, int key, Command command) {
        FileHandler fileHandler = new FileHandler();
        if (command == DECRYPT || command == ENCRYPT) {
            processText(alphabet, inputMessage, key, command);
        }
        else if (command == BRUTE_FORCE){
            crackCaesarCipher(alphabet, inputMessage);
        }

    }
    private String processText(String alphabet, String inputMessage, int key, Command command) {
        char[] charsToEncrypt = inputMessage.toLowerCase().toCharArray();
        var stringBuilder = new StringBuilder();
        for (char character : charsToEncrypt) {
            stringBuilder.append(processChar(alphabet, character, key, command));
        }
        outputMessage = stringBuilder.toString();
        fileHandler.writeFile(outputMessage, command.toString());
        return stringBuilder.toString();
    }

    private char processChar(String alphabet, char character, int encryptionKey, Command command) {
        char encryptedChar;
        int encryptionIndex = switch (command) {
            case ENCRYPT -> getEncryptionIndex(alphabet, character, encryptionKey);
            case DECRYPT -> getEncryptionIndex(alphabet, character, -1 * encryptionKey);
            default ->  0;
        };
        encryptedChar = alphabet.charAt(encryptionIndex);
        return encryptedChar;
    }
    private int getEncryptionIndex (String alphabet, char character, int encryptionKey)
    {
        return (alphabet.length() + alphabet.indexOf(character) + encryptionKey) % alphabet.length();
    }

    public String getMessage() {
        return outputMessage;
    }

    private void crackCaesarCipher(String alphabet, String inputMessage) {
        for (int key = 1; key <= alphabet.length(); key++) {
            String decryptedText = processText(alphabet, inputMessage, key ,DECRYPT);
            outputMessage = decryptedText;
            String fileNameByTenChars = decryptedText.substring(0, 10);
            fileHandler.writeFile(outputMessage,BRUTE_FORCE + " (" + fileNameByTenChars + ")");
        }
    }
}
