package com.javarush.shirokova;

import java.util.*;

public class Alphabet {

    private static final Character[] ENGLISH_LOWERCASE_LETTERS = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
    };

    private static final Character[] RUSSIAN_LOWERCASE_LETTERS = {
            'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л',
            'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш',
            'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'
    };

    private static final Character[] PUNCTUATION_SYMBOLS = {
            ' ', '!', '"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',',
            '-', '.', '/', ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']',
            '^', '_', '`', '{', '|', '}', '~', '«', '»'
    };

    private static final Character[] DIGITS = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
    };

    private final List<Character> alphabet;
    private final Map<Character, Integer> charIndexes;

    public Alphabet() {
        List<Character> tempAlphabet = new ArrayList<>();

        tempAlphabet.addAll(Arrays.asList(ENGLISH_LOWERCASE_LETTERS));
        tempAlphabet.addAll(Arrays.asList(RUSSIAN_LOWERCASE_LETTERS));
        tempAlphabet.addAll(Arrays.asList(PUNCTUATION_SYMBOLS));
        tempAlphabet.addAll(Arrays.asList(DIGITS));

        alphabet = List.copyOf(tempAlphabet);

        charIndexes = new HashMap<>();
        for (int i = 0; i < alphabet.size(); i++) {
            charIndexes.put(alphabet.get(i), i);
        }
    }

    public Character getCharByIndex(int index) {
        if (index < 0 || index > alphabet.size()) {
            throw new AlphabetException("Invalid index: " + index +
                    "Valid is from 0 to " + alphabet.size());
        }
        return alphabet.get(index);
    }

    public int getIndexOfChar(Character character) {
        if (!charIndexes.containsKey(character)) {
            throw new AlphabetException("Invalid character: " + character + ".");
        }
        return charIndexes.get(character);
    }

    public int getSize() {
        return alphabet.size();
    }
}