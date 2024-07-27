package com.javarush.borisov.logic;

import java.io.*;


import java.nio.file.Path;


public class Decrypt {
    private final Path pathToFileToDecrypt;
    private final Path pathToDecryptedFile;
    private final int key;
    private char[] alphabet;


    public Decrypt(Path pathToFileToDecrypt, int key, Path pathToDecryptedFile, char[] alphabet) {
        this.pathToFileToDecrypt = pathToFileToDecrypt;
        this.pathToDecryptedFile = pathToDecryptedFile;
        this.key = key;
        this.alphabet = alphabet;

    }

    public void runDecrypt() throws FileNotFoundException,RuntimeException {

        if (!pathToFileToDecrypt.toFile().exists()) {
            throw new FileNotFoundException();
        }
        try (InputStream inputStream = new FileInputStream(pathToFileToDecrypt.toFile());
             InputStreamReader reader = new InputStreamReader(inputStream);
             OutputStream outputStream = new FileOutputStream(pathToDecryptedFile.toFile());
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream)) {


            int c;

            while ((c = reader.read()) > 0) {


                int a = decryptedMyChar(c);
                outputStreamWriter.write(a);

            }
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private char decryptedMyChar(int c) {

        if (findIndexEncChar((char) c)==-1){
            return (char) c;
        }
        int decryptedIndex = findIndexEncChar((char) c);
            if (decryptedIndex - key < 0) {
               decryptedIndex = alphabet.length  + (decryptedIndex - key);
               return alphabet[decryptedIndex];
            }if (decryptedIndex - key == 0) {

            return alphabet[0];
        }


        return alphabet[decryptedIndex-key];
    }
    private int findIndexEncChar(char ch){
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i]==ch){
                return i;
            }
        }
        return -1;
    }

}
