package com.javarush.borisov.logic;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class StatDecode extends Reader {
    private static Map<Character, Character> newAlphabet = new HashMap<>();
    //  private static final Path encryptedFile = Path.of("c:\\111\\111.txt");
    private static Path encryptedFile = Path.of("c:\\111\\encrypt.txt");
    private static Path decryptedFile = Path.of("c:\\111\\decrypt.txt");
    private static Path tempFile = Path.of("c:\\111\\temp.txt");
    private static String line = "";
    private static int count = 1000;

    //    public void runStatDecode(){
    public static void main(String[] args) {
        Reader.changeSimbol(encryptedFile,  tempFile, " " , "^!?^"); // заменяем то что сейчас является пробелом
        line = Reader.read(tempFile);
        addToNewAlphabet(findFrequentChar(line), ' ');// вычисляем пробелы и добавляем в новый алфавит
        decrypt(tempFile, decryptedFile);
        Reader.changeSimbol(decryptedFile, tempFile, "  " , " ");
        line = Reader.read(tempFile);
        addToNewAlphabet(findFrequentDoubleChar(line, ' '), 'о');// вычислили 'о' ??? добавляем в новый алфавит
        line = "";
        decrypt(tempFile,decryptedFile);
        line = Reader.read(decryptedFile);
        addToNewAlphabet(findFrequentDoubleChar(line, 'о'), 'в');// вычислили 'в' ??? добавляем в новый алфавит

        System.out.println(newAlphabet);


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

    private static void decrypt(Path pathToRead, Path pathToSave) {

        try (BufferedReader reader = Files.newBufferedReader(pathToRead);
             BufferedWriter writer = Files.newBufferedWriter(pathToSave)) {


            while (reader.ready()) {
                String list = reader.readLine();
                if (list.equals("")) {
                    continue;
                }
                char[] tmp = list.toCharArray();
                for (int j = 0; j < tmp.length; j++) {

                    if (newAlphabet.containsKey(tmp[j])) {
                        tmp[j] = newAlphabet.get(tmp[j]);
                    }

                }
                if (count != 1) {
                    writer.write((String.valueOf(tmp)).replaceAll("  ", " ") + "\n");
                } else {
                    writer.write((String.valueOf(tmp)).replaceAll("  ", " ") + "\n");
                }
            }
            count = 0;

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }


}
