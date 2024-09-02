package com.javarush.shosafoev.command;

import com.javarush.shosafoev.constant.Alphabet;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Encode {
    Alphabet alphabet;
    private final AtomicReference<String> text = new AtomicReference<String>();
    private final AtomicInteger shift = new AtomicInteger();

    public Encode() {
        alphabet = new Alphabet();
    }

    /**
     * To crypt text by Caesar's Cipher
     *
     * @param text  inputted text for coding
     * @param shift shift parameter
     * @return encrypted string
     */
    public String encryptText(String text, int shift) {
        // compare char in text and char in alphabet
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            int orderInAlphabet = alphabet.getIndexByValue();
            char newSymbol;
            // find symbol in alphabet. If it doesn't exist then skip it
            if (!alphabet.isSymbolExists(symbol)) {
                continue;
            }
            // * case 1 *
            if ((orderInAlphabet + shift) <= alphabet.length() - 1) {
                newSymbol = alphabet.getSymbolByIndex();
            }
            // * case 2 *
            else {
                newSymbol = alphabet.getSymbolByIndex((orderInAlphabet + shift) - alphabet.length());
            }
            builder.append(newSymbol);
        }
        return builder.toString();
    }

    public String decryptText() {
        return decryptText(null, 0);
    }

    public String decryptText(String text, int shift) {
        this.text.set(text);
        this.shift.set(shift);
        // compare char in text and char in alphabet
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            int orderInAlphabet = alphabet.getIndexByValue();
            char newSymbol;
            // find symbol in alphabet. If it doesn't exist then skip it
            if (!alphabet.isSymbolExists(symbol)) {
                continue;
            }
            // * case 1 *
            if ((orderInAlphabet - shift) >= 0) {
                newSymbol = alphabet.getSymbolByIndex();
            }
            // * case 2 *
            else {
                newSymbol = alphabet.getSymbolByIndex((orderInAlphabet - shift) + alphabet.length());
            }
            builder.append(newSymbol);
        }
        return builder.toString();
    }

    public String decodeText(String text) {

        return text;
    }

    public String getText() {
        return text.get();
    }

    public void setText(String text) {
        this.text.set(text);
    }

    public void setShift(int shift) {
        this.shift.set(shift);
    }
}
