package com.javarush.borisov.logic;

import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindFreqChar {
    public static char findFrequentChar(String line) {
        Map<Character, Integer> chars = new HashMap<>();

        for (int i = 0; i < line.length(); i++) {
            if (chars.containsKey(line.charAt(i))) {

                chars.put(line.charAt(i), chars.get(line.charAt(i)) + 1);
            } else chars.put(line.charAt(i), 1);

        }
        int maxValue = Integer.MIN_VALUE; // Начальное значение
        char key = 0;
        for (Map.Entry entry : chars.entrySet()) {
            if (Integer.parseInt(entry.getValue().toString()) > maxValue) {
                if(!StatDecode.newAlphabet.containsValue(entry.getKey())) {
                    maxValue = Integer.parseInt(entry.getValue().toString());
                    key = entry.getKey().toString().charAt(0);
                }
            }
        }
        System.out.println("чар: |" + key + "| частота встречи " + maxValue);
        return key;

    }

    public static char[] findFrequentDoubleChar(String line, String regex, int regexLength, int returnPos) {
        Map<String, Integer> doubleChar = new HashMap<>();

        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < line.length() - regexLength ; i++) {
            String tmp = line.substring(i, i + regexLength );
            Matcher matcher = pattern.matcher(tmp);
            if (matcher.find()) {
                if(doubleChar.containsKey(tmp) && !StatDecode.newAlphabet.containsValue(tmp.charAt(returnPos))) {
                    doubleChar.put(tmp, Integer.parseInt(doubleChar.get(tmp).toString()) + 1);
                }else{
                    doubleChar.put(tmp, 1);
                }
            }


        }


        int maxValue = Integer.MIN_VALUE; // Начальное значение
        String key = "";
        for (Map.Entry entry : doubleChar.entrySet()) {


            if (Integer.parseInt(entry.getValue().toString()) > maxValue) {
                key = entry.getKey().toString().substring(0,regexLength);
                if (!StatDecode.newAlphabet.containsValue(key.charAt(returnPos))) {
                    maxValue = Integer.parseInt(entry.getValue().toString());
                }


            }
//
//
        }
        System.out.println("пара = |" + key + "|" + " частота встречи = |" + maxValue + "|");


        System.out.println(doubleChar);

        return key.toCharArray();


    }
}