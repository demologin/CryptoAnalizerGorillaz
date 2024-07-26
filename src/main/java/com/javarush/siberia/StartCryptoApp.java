package com.javarush.siberia;

import com.javarush.siberia.cipher.CaesarCipher;
import com.javarush.siberia.entity.Result;

public class StartCryptoApp {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("Добро пожаловать в примитивный шифровальщик, который Цезарь завещал.");
        System.out.println();

        //для тест - удалить----------------------------------------------------------------------------------
        CaesarCipher cipher = new CaesarCipher();

        // Тестовый текст
        String testText = "Hello, World! Привет, мир!";
        int shift = 0;

        // Шифровка
        String encryptedText = cipher.encrypt(testText, shift);
        System.out.println("\nИсходный текст: " + testText);
        System.out.println("Шифрованный текст (сдвиг " + shift + "): " + encryptedText);
        System.out.println("---------------------------------------------------------");

        // Расшифровка
        String decryptedText = cipher.decrypt(encryptedText, shift);
        System.out.println("\nРасшифрованный текст (сдвиг " + shift + "): " + decryptedText);
        System.out.println("---------------------------------------------------------");

        //для теста - удалить ----------------------------------------------------------------------------

        Application application = new Application();
        Result result = application.run(args);
        System.out.println(result);
    }
}