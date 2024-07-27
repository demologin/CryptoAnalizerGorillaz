package com.javarush.borisov.logic;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class ButForce {
    private final Path pathToFileToDecrypt;
    private final Path pathToDecryptedFile;


    public ButForce(Path pathToEncryptedFile, Path pathToDecryptedFile) {
        this.pathToFileToDecrypt = pathToEncryptedFile;
        this.pathToDecryptedFile = pathToDecryptedFile;

    }


        public    void runBF() throws FileNotFoundException{
        try (BufferedReader reader = Files.newBufferedReader(pathToFileToDecrypt)){
            int count =20;
            String lines="";
            while (reader.ready()) {
                 lines = lines + reader.readLine() + "\n";
                if(count==0){
                    int key = findKey(findFrequentChar(lines));
                    Decrypt decryptBF = new Decrypt(pathToFileToDecrypt, key,pathToDecryptedFile);
                    decryptBF.runDecrypt();
                }
                count--;
            }
            if(count >0) {
                int key = findKey(findFrequentChar(lines));
                Decrypt decryptBF = new Decrypt(pathToFileToDecrypt, key,pathToDecryptedFile);
                decryptBF.runDecrypt();
            }


        }catch (FileNotFoundException | NoSuchFileException e){
            throw new FileNotFoundException(e.getMessage());
        } catch (Exception e){

            throw new RuntimeException(e.getMessage());
        }




    }
    private static char findFrequentChar(String line)  {
        Map<Character,Integer> chars = new HashMap<>();

        for (int i = 0; i < line.length(); i++) {
            if(chars.containsKey(line.charAt(i))) {

                chars.put(line.charAt(i), chars.get(line.charAt(i)) + 1);
            }else chars.put(line.charAt(i), 1);

        }
        int maxValue = Integer.MIN_VALUE; // Начальное значение
        char key=0;
        for (Map.Entry entry : chars.entrySet()) {
            if (Integer.parseInt(entry.getValue().toString()) > maxValue) {
                maxValue = Integer.parseInt(entry.getValue().toString());
                key = entry.getKey().toString().charAt(0);
                
            }
        }

        return key;

    }
    private static int findKey(char symbol){
            int indexOfEncryptedSpase=0;
            int indexOfRealSpase=0;
            int key;
        for (int i = 0; i < Const.alphabet.length; i++) {
            if(symbol==Const.alphabet[i]){
                indexOfEncryptedSpase =i;
            }
            if(Const.alphabet[i]==' '){
                indexOfRealSpase=i;
            }
        }
        if(indexOfEncryptedSpase - indexOfRealSpase>0){
            key=indexOfEncryptedSpase - indexOfRealSpase;
        }else {
            key = Const.alphabet.length - indexOfRealSpase + indexOfEncryptedSpase;
        }
        if(key != Const.alphabet.length) {
            System.out.println(Messages.KEY_GRANTED + "" + key);
        }else {
            System.out.println(Messages.KEY_IS_NULL);
        }




            return key;
    }

}
