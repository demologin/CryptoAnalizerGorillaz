package com.javarush.borisov.logic;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class ButForce extends FindFreqChar {
    private final Path pathToEncryptedFile;
    private final Path pathToDecryptedFile;


    public ButForce(Path pathToEncryptedFile, Path pathToDecryptedFile) {
        this.pathToEncryptedFile = pathToEncryptedFile;
        this.pathToDecryptedFile = pathToDecryptedFile;

    }


        public    void runBF() throws FileNotFoundException{
        try (BufferedReader reader = Files.newBufferedReader(pathToEncryptedFile)){
            int count =200;
            String lines="";
            while (reader.ready()) {
                 lines = lines + reader.readLine() + "\n";
                if(count==0){
                    int key = findKey(findFrequentChar(lines));
                    Decrypt decryptBF = new Decrypt(pathToEncryptedFile, key,pathToDecryptedFile,Const.ALPHABET);
                    decryptBF.runDecrypt();
                }
                count--;
            }
            if(count >0) {
                int key = findKey(findFrequentChar(lines));
                Decrypt decryptBF = new Decrypt(pathToEncryptedFile, key,pathToDecryptedFile,Const.ALPHABET);
                decryptBF.runDecrypt();
            }


        }catch (FileNotFoundException | NoSuchFileException e){
            throw new FileNotFoundException(e.getMessage());
        } catch (Exception e){

            throw new RuntimeException(e.getMessage());
        }




    }

    private static int findKey(char symbol){
            int indexOfEncryptedSpase=0;
            int indexOfRealSpase=0;
            int key;
        for (int i = 0; i < Const.ALPHABET.length; i++) {
            if(symbol==Const.ALPHABET[i]){
                indexOfEncryptedSpase =i;
            }
            if(Const.ALPHABET[i]==' '){
                indexOfRealSpase=i;
            }
        }
        if(indexOfEncryptedSpase - indexOfRealSpase>0){
            key=indexOfEncryptedSpase - indexOfRealSpase;
        }else {
            key = Const.ALPHABET.length - indexOfRealSpase + indexOfEncryptedSpase;
        }
        if(key != Const.ALPHABET.length) {
            System.out.println(Messages.KEY_GRANTED + "" + key);
        }else {
            System.out.println(Messages.KEY_IS_NULL);
        }




            return key;
    }

}
