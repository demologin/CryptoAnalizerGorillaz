package com.javarush.borisov.logic;


import com.javarush.borisov.logic.exception.MyException;

import java.io.BufferedReader;
import java.io.BufferedWriter;



import java.nio.file.*;


public class Encrypt {
    private final Path pathToFileToEncrypt;
    private final Path pathToEncryptedFile;
    private final int key;


    public Encrypt(Path pathToFileToEncrypt, int key, Path pathToEncryptedFile) {

        this.pathToFileToEncrypt = pathToFileToEncrypt;
        this.key = key;
        this.pathToEncryptedFile = pathToEncryptedFile;


    }

    public void runEncrypt()  {

        System.out.println(Messages.ENCODE);
       try( BufferedReader reader = Files.newBufferedReader(pathToFileToEncrypt);
        BufferedWriter writer = Files.newBufferedWriter(pathToEncryptedFile)) {
           while (reader.ready()) {


               String list = reader.readLine().toLowerCase();

               char[] tmp = list.toCharArray();
               for (int j = 0; j < tmp.length; j++) {
                   tmp[j] = alphabetNewChar(tmp[j], key);


               }
               writer.write(String.valueOf(tmp)+"\n");


           }
       }catch (Exception e){
                if(e.toString().contains("NoSuchFileException")) {
                    throw new MyException("Файл не существует", e);
                } else if (e.toString().contains("AccessDeniedException")) {
                    throw new MyException("Отказано в доступе", e);
                }

           throw new MyException("неизвестная ошибка ", e);

       }

        System.out.println(Messages.ENCODE_FINISH);

    }

    private char alphabetNewChar(char tmp, int key) {

        int index =-1;
        for (int i = 0; i < Const.ALPHABET.length; i++) {
            if (tmp == Const.ALPHABET[i]) {
                index = i;
            }
        }


        if (index < 0) {
            return tmp;
        }

        if (index + key > Const.ALPHABET.length) {
            int keyTemp = key - (Const.ALPHABET.length  - index);

            return Const.ALPHABET[keyTemp];
        }
        if (index + key == Const.ALPHABET.length) {


            return Const.ALPHABET[0];
        }
        return Const.ALPHABET[index + key];
    }


}
