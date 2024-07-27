package com.javarush.borisov.logic;


import java.io.BufferedReader;
import java.io.BufferedWriter;


import java.io.FileNotFoundException;
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

    public void runEncrypt() throws RuntimeException, AccessDeniedException, FileNotFoundException {

        System.out.println(Messages.ENCODE);
       try( BufferedReader reader = Files.newBufferedReader(pathToFileToEncrypt);
        BufferedWriter writer = Files.newBufferedWriter(pathToEncryptedFile)) {
           while (reader.ready()) {


               String list = reader.readLine();

               char[] tmp = list.toCharArray();
               for (int j = 0; j < tmp.length; j++) {
                   tmp[j] = alphabetNewChar(tmp[j], key);


               }
               writer.write(String.valueOf(tmp)+"\n");


           }
       }catch (AccessDeniedException e){

           throw new AccessDeniedException("");
       }catch (NoSuchFileException e){

           throw new FileNotFoundException(pathToFileToEncrypt+"\n" + pathToEncryptedFile + Messages.FILE_NOT_FOUND);
       }catch (Exception e){
           System.out.println(Messages.UNKNOWN_ERROR +e.getMessage());
       }


//        Files.writeString(pathToEncryptedFile, list.get(0), Charset.defaultCharset());
//        for (int i = 1; i < list.size(); i++) {
//
//            Files.writeString(pathToEncryptedFile, "\n" + list.get(i), StandardOpenOption.APPEND);
//        }


        System.out.println(Messages.ENCODE_FINISH);

    }

    private char alphabetNewChar(char tmp, int key) {

        int index =-1;
        for (int i = 0; i < Const.alphabet.length; i++) {
            if (tmp == Const.alphabet[i]) {
                index = i;
            }
        }


        if (index < 0) {
            return tmp;
        }

        if (index + key > Const.alphabet.length) {
            int keyTemp = key - (Const.alphabet.length  - index);

            return Const.alphabet[keyTemp];
        }
        if (index + key == Const.alphabet.length) {


            return Const.alphabet[0];
        }
        return Const.alphabet[index + key];
    }


}
