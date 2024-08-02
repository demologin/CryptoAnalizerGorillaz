package com.javarush.borisov.logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class AnaliseDecript {
    Path pathToSave;
    String line;
    char checkedChar;
    public AnaliseDecript() {

    }
    public AnaliseDecript(Path pathToSave) {
        this.pathToSave = pathToSave;
    }

    public AnaliseDecript(String line,char checkedChar) {
        this.line = line;
        this.checkedChar=checkedChar;
    }

    public String decrypt(String line, char checkedChar) {


                for(int i = 0;i<line.length();i++) {
                   char[] tmp = line.toCharArray();
                    for (int j = 0; j < tmp.length; j++) {

                        if (StatDecode.newAlphabet.containsKey(tmp[j])) {
                            tmp[j] = StatDecode.newAlphabet.get(tmp[j]);
                        } else if (StatDecode.newAlphabet.containsValue(tmp[j])) {
                            for (Map.Entry<Character, Character> entry : StatDecode.newAlphabet.entrySet()) {
                                if (entry.getValue().equals(tmp[j]) && StatDecode.newAlphabet.containsKey(tmp[j]) && StatDecode.newAlphabet.get(tmp[j]).equals(checkedChar)) {
                                    tmp[j] = entry.getKey();
                                }
                            }
                        }
                    }
                }

//                writer.write(String.valueOf(tmp) + "\n");


            return "";

    }
}
