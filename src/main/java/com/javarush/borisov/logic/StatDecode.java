package com.javarush.borisov.logic;
// todo заменять известные символы при дешифровке
import com.javarush.borisov.logic.Analyse.CreateAlphabetCast;
import com.javarush.borisov.logic.Analyse.CreateNewAlphabet;
import com.javarush.borisov.logic.Analyse.Reader;

import java.io.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class StatDecode extends Reader {
    public static Map<Character, Character> newAlphabet = new HashMap<>();
   // private static final Path encryptedFile = Path.of("c:\\111\\111.txt");
   private static Path encryptedFile = Path.of("c:\\111\\encrypted.txt");
    private static Path decryptedFile = Path.of("c:\\111\\decrypt.txt");
    private static Path dicFile = Path.of("c:\\111\\dic.txt");
    private static Path tempFile = Path.of("c:\\111\\temp.txt");
    private static String line = "";
    private static int count = 1000;
    private static final Map<Character, Integer> allSimbols= new HashMap<>();
    private static final String rus = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final String eng = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String num = "1234567890";
    private static final String cym = "!@#$%^&*()_+-=*/.,<>[]{};:'\" `~";
    private static final String alphabet1 = (rus + rus.toLowerCase() + eng + eng.toLowerCase() + num + cym);
    public static final char[] ALPHABET = alphabet1.toCharArray();

    private static Map<String, Integer> dicAlphabet ;
    private static Map<String, Integer> encAlphabet ;

    public static void main(String[] args) {


        Reader reader = new Reader();


        CreateAlphabetCast dicAlphabetCast = new CreateAlphabetCast();
        dicAlphabet = dicAlphabetCast.createAlphabetCast(reader.read(dicFile));


        CreateAlphabetCast encAlphabetCast = new CreateAlphabetCast();
        encAlphabet = encAlphabetCast.createAlphabetCast(reader.read(encryptedFile));

        CreateNewAlphabet newAlphabet = new CreateNewAlphabet();
        newAlphabet.createNewAlphabet(dicAlphabet,encAlphabet);

    }









}
