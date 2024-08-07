package com.javarush.kartsev.constant;

import java.util.HashMap;
import java.util.Map;

public class Alphabet {

    private Alphabet() {
    }

    private static final String rus = "йцукенгшщзхъёфывапролджэячсмитьбю";
    private static final String symb = "\n☮.,”’:-!? ";

    public static final char[] CHARS = (rus.toUpperCase() + symb).toCharArray();

    public final static Map<Character, Integer> index = new HashMap<>();

    static {
        for (int i = 0; i < CHARS.length; i++) {
            index.put(CHARS[i], i);
        }
    }


}
