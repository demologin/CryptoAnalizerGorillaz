package com.javarush.kazakov;
import java.util.Scanner;
public class CaesarCipher {
    private String alphabet;

    // Конструктор по умолчанию с латинским алфавитом
    public CaesarCipher() {
        this.alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    }

    // Конструктор с пользовательским алфавитом
    public CaesarCipher(String customAlphabet) {
        this.alphabet = customAlphabet.toUpperCase();
    }

    // Метод для установки алфавита
    public void setAlphabet(String newAlphabet) {
        this.alphabet = newAlphabet.toUpperCase();
    }

    // Метод для шифрования строки
    public String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            int index = alphabet.indexOf(Character.toUpperCase(c));

            if (index != -1) {
                int newIndex = (index + shift) % alphabet.length();
                char shiftedChar = alphabet.charAt(newIndex);

                // Сохраняем регистр исходного символа
                if (Character.isLowerCase(c)) {
                    shiftedChar = Character.toLowerCase(shiftedChar);
                }
                result.append(shiftedChar);
            } else {
                // Если символ не найден в алфавите, добавляем его без изменений
                result.append(c);
            }
        }

        return result.toString();
    }

    // Метод для расшифровки строки
    public String decrypt(String text, int shift) {
        return encrypt(text, alphabet.length() - shift);
    }

    // Метод для брутфорс расшифровки
    public void bruteForceDecrypt(String text) {
        for (int i = 1; i < alphabet.length(); i++) {
            String decryptedText = decrypt(text, i);
            System.out.println("Сдвиг " + i + ": " + decryptedText);
        }
    }
}