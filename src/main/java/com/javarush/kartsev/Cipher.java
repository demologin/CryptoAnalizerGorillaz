package com.javarush.kartsev;

public class Cipher {
    private char[] alphabet;

    public Cipher(char[] alphabet) {
        this.alphabet = alphabet;
    }

    public String encrypt(String text, int shift) {
        // логика шифрования
        return text;
    }

    public String decrypt(String encryptedText, int shift) {
        // Логика расшифровки
        return encryptedText;
    }
}
