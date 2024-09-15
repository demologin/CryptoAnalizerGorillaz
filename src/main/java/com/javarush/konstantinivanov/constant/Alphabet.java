package com.javarush.konstantinivanov.constant;

import java.util.HashMap;
import java.util.Map;

public class Alphabet {
    private Alphabet() {
    }

    private static final String RUS = "ЙЦУКЕНГШЩЗХЪФЫВАПРОЛДЖЭЯЧСМИТЬБЮЁ";
    private static final String SYMBOLS = "\n☮.,”’:-!? ";

    public static final char[] CHARS = (RUS.toLowerCase() + SYMBOLS).toCharArray();

    public final static Map<Character, Integer> index = new HashMap<>();

    static {
        for (int i = 0; i < CHARS.length; i++) {
            index.put(CHARS[i], i);
        }
    }
}
