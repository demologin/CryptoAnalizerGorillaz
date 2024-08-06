package com.javarush.ryzhikov.dictionary;

import java.util.HashMap;

public class Alphabet {

    private static final char[] alphabetArray = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
            'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' ', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};


    public static final int ALPHABET_LENGTH = alphabetArray.length;

    private static final HashMap<Character, Integer> alphabetCharacterKey = new HashMap();

    static {
        for (int i = 0; i < alphabetArray.length; i++) {
            alphabetCharacterKey.put(alphabetArray[i], i);
        }
    }

    public static int getIndex(char character) {
        return alphabetCharacterKey.get(character);
    }

    public static char getCharacter(int index) {
        return alphabetArray[index];
    }

    public static boolean isExists(char character) {
        return alphabetCharacterKey.containsKey(character);
    }
}
