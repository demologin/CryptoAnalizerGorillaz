package com.javarush.nikitin.constants;

import java.util.*;

public class Alphabet {
    private static final Character[] RUS_CHAR = new Character[33];
    private static final Character[] SYMBOLS = new Character[28];
    private static final List<Character> ALPHABET_CHAR = new ArrayList<>();
    private static final Map<Character, Integer> ALPHABET_INDEX = new HashMap<>();

    static {
        for (int i = 0, startChar = 'а'; i < RUS_CHAR.length; i++, startChar++) {
            RUS_CHAR[i] = (char) startChar;
            if (startChar == 'е') {
                i += 1;
                RUS_CHAR[i] = 'ё';
            }
        }

        for (int i = 0, startChar = ' '; i < SYMBOLS.length; i++, startChar++) {
            SYMBOLS[i] = (char) startChar;
        }

        Collections.addAll(ALPHABET_CHAR, RUS_CHAR);
        Collections.addAll(ALPHABET_CHAR, SYMBOLS);

        for (int i = 0; i < ALPHABET_CHAR.size(); i++) {
            ALPHABET_INDEX.put(ALPHABET_CHAR.get(i), i);
        }
    }

    private Alphabet() {
    }

    public static Integer getIndex(Character ch) {
        return ALPHABET_INDEX.getOrDefault(ch, -1);
    }

    public static Character getChar(Integer index) {
        return ALPHABET_CHAR.get(index);
    }

    public static int size() {
        return ALPHABET_INDEX.size();
    }
}
