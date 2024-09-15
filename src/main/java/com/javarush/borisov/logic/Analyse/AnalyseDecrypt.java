package com.javarush.borisov.logic.Analyse;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class AnalyseDecrypt {
    Map<Character,Character> alphabet = new HashMap();
    public void decrypt(Path pathToReadFile, Path pathToSaveFile, Map alphabet) {
        this.alphabet = alphabet;
        try(BufferedReader reader = Files.newBufferedReader(pathToReadFile);
            BufferedWriter writer = Files.newBufferedWriter(pathToSaveFile)){
            while (reader.ready()) {
                String line = reader.readLine();
                char[] chars = line.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    chars[i] = alphabetContainsValue(chars[i]);
                }
                writer.write(String.valueOf(chars) + "\n");
            }



        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private char alphabetContainsValue(char c){
        for(Map.Entry entry : alphabet.entrySet()){
            if(entry.getValue().equals(c)){
                return (char)entry.getKey();
            }
        }
        return c;
    }
}
