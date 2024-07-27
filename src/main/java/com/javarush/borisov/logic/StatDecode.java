package com.javarush.borisov.logic;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class StatDecode extends FindFreqChar {
    private static Map<Character, Character> newAlphabet = new HashMap<>();
     private static final Path EncryptedFile = Path.of("c:\\111\\111.txt");
   // private static final Path EncryptedFile = Path.of("c:\\111\\encrypt.txt");
    private static final Path DecryptedFile = Path.of("c:\\111\\decrypt.txt");
    private static String line = "";

    //    public void runStatDecode(){
    public static void main(String[] args) {
        try (BufferedReader reader = Files.newBufferedReader(EncryptedFile)) {
            while (reader.ready()) {
                line = line + reader.readLine() + "\n";
            }
            System.out.println("|" + findFrequentChar(line) + "|");
            addToNewAlphabet(findFrequentChar(line), ' ');// вычисляем пробелы и добавляем в новый алфавит
            decrypt();
        } catch (IOException e) {
            e.printStackTrace();
        }
        findFrequentDoubleChar(line,' ');

    }

    private static void addToNewAlphabet(char a, char b) {
        newAlphabet.put(a, b);
    }

    private static char[] alphabetToCharArray(Map<Character, Character> alphabet) {
        char[] al = new char[alphabet.size()];
        int i = alphabet.size() - 1;
        for (Map.Entry entry : alphabet.entrySet()) {
            al[i] = (char) entry.getKey();

        }
        return al;
    }
    private static void decrypt (){
        try (InputStream inputStream = new FileInputStream(EncryptedFile.toFile());
             InputStreamReader reader = new InputStreamReader(inputStream);
             OutputStream outputStream = new FileOutputStream(DecryptedFile.toFile());
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream)) {


            int c;

            while ((c = reader.read()) > 0) {

                if (newAlphabet.containsKey((char)c)){
                    outputStreamWriter.write(newAlphabet.get((char)c));
                }else {


                    outputStreamWriter.write(c);
                }

            }
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }


}
