package com.javarush.borisov.logic;

import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

public class FindFreqChar {
    protected static char findFrequentChar(String line) {
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
                maxValue = Integer.parseInt(entry.getValue().toString());
                key = entry.getKey().toString().charAt(0);

            }
        }
        // System.out.println(chars);
        return key;

    }

    public static char findFrequentDoubleChar(String line, char knownChar) {
        Map<String, Integer> doubleChar = new TreeMap<>();
        for (int i = 0; i < line.length()-1; i++) {
            if (doubleChar.containsKey((line.charAt(i) +""+ knownChar))) {

                doubleChar.put(((line.charAt(i) + "" + knownChar)), doubleChar.get((line.charAt(i) + "" + knownChar)) + 1);
            }else doubleChar.put((line.charAt(i) + "" + knownChar), 1);
        }
        int maxValue = Integer.MIN_VALUE; // Начальное значение
        String key = "";
        for (Map.Entry entry : doubleChar.entrySet()) {
            if (Integer.parseInt(entry.getValue().toString()) > maxValue) {
                maxValue = Integer.parseInt(entry.getValue().toString());
                key = entry.getKey().toString();

            }


        }
        System.out.println("пара = |" + key + "|");


        System.out.println(doubleChar);
        return ' ';
    }

}
