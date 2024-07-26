package com.javarush.borisov.logic;


import java.io.BufferedReader;
import java.io.BufferedWriter;



import java.nio.file.*;
import java.util.Arrays;


public class Encrypt {
    private final Path pathToFileToEncrypt;
    private final Path pathToEncryptedFile;
    private final int key;


    public Encrypt(Path pathToFileToEncrypt, int key, Path pathToEncryptedFile) {

        this.pathToFileToEncrypt = pathToFileToEncrypt;
        this.key = key;
        this.pathToEncryptedFile = pathToEncryptedFile;


    }

    public void runEncrypt() throws Exception {

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

           throw new NoSuchFileException(pathToFileToEncrypt+"\n" + pathToEncryptedFile + Messages.FILE_NOT_FOUND);
       }catch (Exception e){
           System.out.println(Messages.UNKNOWN_ERROR);
       }


//        Files.writeString(pathToEncryptedFile, list.get(0), Charset.defaultCharset());
//        for (int i = 1; i < list.size(); i++) {
//
//            Files.writeString(pathToEncryptedFile, "\n" + list.get(i), StandardOpenOption.APPEND);
//        }


        System.out.println(Messages.ENCODE_FINISH);

    }

    private char alphabetNewChar(char tmp, int key) {
        int index = Arrays.binarySearch(Const.alphabet, tmp);
        if (index < 0) {
            return tmp;
        }

        if (index + key >= Const.alphabet.length) {
            int temp = Const.alphabet.length - 1 - index;

            return Const.alphabet[temp];
        }
        return Const.alphabet[index + key];
    }


}
