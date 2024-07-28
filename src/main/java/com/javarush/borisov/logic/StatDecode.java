package com.javarush.borisov.logic;
// todo заменять известные символы при дешифровке
import com.sun.jdi.Value;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class StatDecode extends Reader {
    public static Map<Character, Character> newAlphabet = new HashMap<>();
    //  private static final Path encryptedFile = Path.of("c:\\111\\111.txt");
    private static Path encryptedFile = Path.of("c:\\111\\encrypt.txt");
    private static Path decryptedFile = Path.of("c:\\111\\decrypt.txt");
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



    public static void main(String[] args) {
        char unused = searchUnusedSymbol();

        Reader.changeSimbol(encryptedFile,  tempFile, " " , String.valueOf(unused)); // заменяем то что сейчас является пробелом
        line = Reader.read(tempFile);

       decrypt(tempFile, decryptedFile,addToNewAlphabet(findFrequentChar(line), ' '));// вычисляем пробелы и добавляем в новый алфавит и расшифровываем символ
       //Reader.changeSimbol(decryptedFile, tempFile, "  " , " ");

       line = Reader.read(decryptedFile);
       decrypt(decryptedFile,tempFile,addToNewAlphabet(findFrequentDoubleChar(line, "\\S\\s",2 ,0), ','));// вычислили ','  добавляем в новый алфавит

//
      decrypt(tempFile,decryptedFile,addToNewAlphabet(findFrequentChar(line), 'о'));
        line = Reader.read(decryptedFile);
      // вычислили 'о' добавляем в новый алфавит
       //char a = findFrequentChar(line);
        decrypt(decryptedFile,tempFile,addToNewAlphabet(findFrequentDoubleChar(line, "\\s\\S\\s",3 ,1), 'и'));// вычислили 'в' ??? добавляем в новый алфавит
        System.out.println(newAlphabet);


    }

    private static char addToNewAlphabet(char a, char b) {
        newAlphabet.put(a, b);
        return b;
    }

    private static char[] alphabetToCharArray(Map<Character, Character> alphabet) {
        char[] al = new char[alphabet.size()];
        int i = alphabet.size() - 1;
        for (Map.Entry entry : alphabet.entrySet()) {
            al[i] = (char) entry.getKey();

        }
        return al;
    }

    private static void decrypt(Path pathToRead, Path pathToSave,char checkedChar) {

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
                    }else if(newAlphabet.containsValue(tmp[j])) {
                        for (Map.Entry<Character, Character> entry : newAlphabet.entrySet()) {
                            if (entry.getValue().equals(tmp[j])&&newAlphabet.containsKey(tmp[j]) && newAlphabet.get(tmp[j]).equals(checkedChar)) {
                                tmp[j] = entry.getKey();
                            }
                        }
                    }
                }

                    writer.write(String.valueOf(tmp) + "\n");

            }
            count = 0;

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    private static char searchUnusedSymbol(){
        line = Reader.read(encryptedFile);
        for (int i = 0; i < line.length(); i++) {
            if(allSimbols.containsKey(line.charAt(i))){
                allSimbols.put(line.charAt(i), allSimbols.get(line.charAt(i))+1);
            }else {
                allSimbols.put(line.charAt(i), 1);
            }


        }
        line = Reader.read(encryptedFile);

        int minValue = Integer.MAX_VALUE;
        char key='L' ;
        for(Map.Entry<Character, Integer> entry : allSimbols.entrySet()){
            if (Integer.parseInt(entry.getValue().toString()) < minValue) {
                minValue = Integer.parseInt(entry.getValue().toString());
                key = entry.getKey();
            }
        }
        System.out.println("самый редкий символ = " + "|"+ key +"|" + " частота встречи - "+ minValue );
        line="";
        return key;
    }


}
