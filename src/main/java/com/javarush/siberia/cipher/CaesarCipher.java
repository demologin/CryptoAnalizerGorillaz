package com.javarush.siberia.cipher;

import com.javarush.siberia.constants.Constants;

public class CaesarCipher {

    private final char[] alphabet = Constants.ALPHABET;

    public char[] encrypt(char[] text, int shift) {
        return shiftText(text, shift);
    }

    public char[] decrypt(char[] text, int shift) {
        return shiftText(text, -shift);
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

    private int indexOf(char character) {
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == character) {
                return i;
            }
        }
        return -1;
    }

    public int analysisIndexOf(char[] alphabet, char character) {
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == character) {
                return i;
            }
        }
        return -1;
    }

    public char[] analysisDecryptText(char[] text, int shift, char[] alphabet) {
        char[] decryptedText = new char[text.length];
        for (int i = 0; i < text.length; i++) {
            int index = analysisIndexOf(alphabet, text[i]);
            if (index != -1) {
                int newIndex = (index - shift + alphabet.length) % alphabet.length;
                decryptedText[i] = alphabet[newIndex];
            } else {
                decryptedText[i] = text[i];
            }
        }
        return decryptedText;
    }
}