package com.javarush.siberia.cipher;

import com.javarush.siberia.constants.Constants;

public class CaesarCipher {

    private final char[] alphabet = Constants.ALPHABET;
    private final char[] analysisAlphabet = Constants.ANALYSIS_ALPHABET;

    public char[] encrypt(char[] text, int shift) {
        return shiftText(text, shift);
    }

    public char[] decrypt(char[] text, int shift) {
        return shiftText(text, -shift);
    }

    public char[] analysisDecrypt(char[] text, int shift, char[] alphabet) {
        return analysisShiftText(text, -shift, analysisAlphabet);
    }

    private char[] analysisShiftText(char[] text, int shift, char[] alphabet) {
        char[] result = new char[text.length];
        int alphabetLength = analysisAlphabet.length;

        for (int i = 0; i < text.length; i++) {
            char currentChar = text[i];
            int index = analysisIndexOf(analysisAlphabet, currentChar);

            if (index != -1) {
                int newIndex = (index + shift + alphabetLength) % alphabetLength;
                result[i] = analysisAlphabet[newIndex];
            } else {
                result[i] = currentChar;
            }
        }
        return result;
    }

    private char[] shiftText(char[] text, int shift) {
        char[] result = new char[text.length];
        int alphabetLength = alphabet.length;

        for (int i = 0; i < text.length; i++) {
            char character = text[i];
            int index = indexOf(character);

            if (index != -1) {
                int newIndex = (index + shift + alphabetLength) % alphabetLength;
                result[i] = alphabet[newIndex];
            } else {
                result[i] = character;
            }
        }
        return result;
    }

    private int analysisIndexOf(char[] array, char target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    private int indexOf(char character) {
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == character) {
                return i;
            }
        }
        return -1;
    }
}
