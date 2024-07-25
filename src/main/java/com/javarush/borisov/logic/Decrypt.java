package com.javarush.borisov.logic;

import java.io.*;

import java.nio.file.Path;


public class Decrypt {
    private final Path pathToFileToDecrypt;
    private final Path pathToDecryptedFile;
    private final int key;


    public Decrypt(Path pathToFileToDecrypt, int key, Path pathToDecryptedFile) {
        this.pathToFileToDecrypt = pathToFileToDecrypt;
        this.pathToDecryptedFile = pathToDecryptedFile;
        this.key = key;

    }

    public void runDecrypt() {
        try (InputStream inputStream = new FileInputStream(pathToFileToDecrypt.toFile());
             InputStreamReader reader = new InputStreamReader(inputStream);
             OutputStream outputStream = new FileOutputStream(pathToDecryptedFile.toFile());
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream)) {


            int length;

            while ((length = reader.read()) > 0) {


                int a = decryptedMyChar(length);
                outputStreamWriter.write(a);

            }
        } catch (IOException e) {

            throw new RuntimeException(e);
        }
    }

    private char decryptedMyChar(int c) {

        if (findIndexEncChar((char) c,Const.alphabet)==-1){
            return (char) c;
        }
        int decryptedIndex = findIndexEncChar((char) c,Const.alphabet);
            if (decryptedIndex - key <= 0) {
               decryptedIndex = Const.alphabet.length - 1 + (decryptedIndex - key);
               return Const.alphabet[decryptedIndex];
            }


        return Const.alphabet[decryptedIndex-key];
    }
    private int findIndexEncChar(char ch, char[] arr){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==ch){
                return i;
            }
        }
        return -1;
    }

}
