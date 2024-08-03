package com.javarush.borisov.logic;
// todo заменять известные символы при дешифровке
import com.javarush.borisov.logic.Analyse.AnalyseDecrypt;
import com.javarush.borisov.logic.Analyse.CreateAlphabetCast;
import com.javarush.borisov.logic.Analyse.CreateNewAlphabet;
import com.javarush.borisov.logic.Analyse.Reader;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class StatDecode extends Reader {
    public static Map<Character, Character> newAlphabet = new HashMap<>();

   private final static Path encryptedFile = Path.of("c:\\111\\encrypted.txt");
    private final static Path decryptedFile = Path.of("c:\\111\\decrypt.txt");
    private final static Path dicFile = Path.of("c:\\111\\dic.txt");




    private static Map<String, Integer> dicAlphabet ;
    private static Map<String, Integer> encAlphabet ;

    public static void main(String[] args) {


        Reader reader = new Reader();


        CreateAlphabetCast dicAlphabetCast = new CreateAlphabetCast();
        dicAlphabet = dicAlphabetCast.createAlphabetCast(reader.read(dicFile));


        CreateAlphabetCast encAlphabetCast = new CreateAlphabetCast();
        encAlphabet = encAlphabetCast.createAlphabetCast(reader.read(encryptedFile));

        CreateNewAlphabet newAlphabet = new CreateNewAlphabet();

        AnalyseDecrypt decrypt = new AnalyseDecrypt();
        decrypt.decrypt(encryptedFile,decryptedFile,newAlphabet.createNewAlphabet(dicAlphabet,encAlphabet));

    }









}
