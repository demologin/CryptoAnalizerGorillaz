package com.javarush.borisov.logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public  class Encrypt {
    private  Path pathToFileToEncrypt;
    private Path pathToEncryptedFile;
    private int key;
    private List<String> list;
    private final char[] alphabet = {'а','б','в','г','д','е','ё','ж','з','и','й','к','л','м',
            'н','о','п','р','с','т','у','ф','х','ц','ч','ш','щ','ъ','ы','ь','э','ю','я'};


    public Encrypt(Path pathToFileToEncrypt, int key, Path pathToEncryptedFile) {

        this.pathToFileToEncrypt = pathToFileToEncrypt;
        this.key = key;
        this.pathToEncryptedFile = pathToEncryptedFile;


    }
    public void runEncrypt(){

        System.out.println("Шифрация...");
        try {
           list  = Files.readAllLines(pathToFileToEncrypt);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < list.size(); i++) {
            char[] tmp = list.get(i).toCharArray();
            for (int j = 0; j < tmp.length; j++) {
               tmp[j] = alphabetNewChar(tmp[j],key);

            }
            list.set(i, String.valueOf(tmp));
        }
        System.out.println(list);

    }

    private char alphabetNewChar(char tmp, int key) {
        int index = Arrays.binarySearch(alphabet, tmp);
        if (index + key >= alphabet.length){
            int temp = alphabet.length - 1 - index;

            return alphabet[temp];
        }
        return alphabet[index + key];
    }


}
