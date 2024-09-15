package com.javarush.shirokova.model;

import java.util.*;

/**
 * The Alphabet class provides a representation of a collection of characters
 * used for encryption and decryption in the application. It includes English
 * and Russian lowercase letters, punctuation symbols, and digits.
 * This class facilitates operations such as obtaining characters by their
 * indices and determining the index of specific characters efficiently.
 */
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

    // List encompassing all characters in the alphabet.
    private final List<Character> alphabet;
    // Map to store character indices for quick lookup.
    private final Map<Character, Integer> charIndexes;

    /**
     * Constructs an Alphabet instance, initializing the alphabet
     * by combining English and Russian lowercase letters, punctuation
     * symbols, and digits. This constructor also creates a mapping
     * of characters to their respective indices for efficient
     * retrieval.
     */
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

    /**
     * Retrieves the character at a specified index in the alphabet.
     *
     * @param index the index of the desired character.
     * @return the character at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    public Character getCharByIndex(int index) {
        return alphabet.get(index);
    }

    /**
     * Finds the index of a specified character in the alphabet.
     *
     * @param character the character whose index is to be found.
     * @return the index of the specified character, or -1 if the
     * character is not found in the alphabet.
     */
    public int getIndexOfChar(Character character) {
        return charIndexes.getOrDefault(character, -1);
    }

    /**
     * Returns the size of the alphabet (i.e., the total number of
     * characters).
     *
     * @return the size of the alphabet.
     */
    public int getSize() {
        return alphabet.size();
    }
}