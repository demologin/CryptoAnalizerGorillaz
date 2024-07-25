package com.javarush.borisov.logic;


import java.io.IOException;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public  class Encrypt {
    private  final Path pathToFileToEncrypt;
    private final Path pathToEncryptedFile;
    private final int key;
    private List<String> list;
    private final char[] alphabet = {'а','б','в','г','д','е','ё','ж','з','и','й','к','л','м',
            'н','о','п','р','с','т','у','ф','х','ц','ч','ш','щ','ъ','ы','ь','э','ю','я'};
    private final char[] simbols = {' ',',','.','/','?','<','>','"',':',';','+','-','='};


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
            throw new RuntimeException("Файл не найден");
        }
        for (int i = 0; i < list.size(); i++) {
            char[] tmp = list.get(i).toCharArray();
            for (int j = 0; j < tmp.length; j++) {
               tmp[j] = alphabetNewChar(tmp[j],key);

            }
            list.set(i, String.valueOf(tmp));
        }
        System.out.println(list);

        try {
            Files.writeString(pathToEncryptedFile,list.get(0), Charset.defaultCharset());
            for (int i = 1; i < list.size(); i++) {

                Files.writeString(pathToEncryptedFile,"\n" +list.get(i), StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        System.out.println("Файл зашифрован");

    }

    private char alphabetNewChar(char tmp, int key) {
        int index = Arrays.binarySearch(Const.alphabet, tmp);
        if (index==-1){
            return tmp;
        }

        if (index + key >= Const.alphabet.length){
            int temp = Const.alphabet.length - 1 - index;

            return Const.alphabet[temp];
        }
        return Const.alphabet[index + key];
    }


}
