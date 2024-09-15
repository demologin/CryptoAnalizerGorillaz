package com.javarush.kazakov;

import java.util.Scanner;

public class Main {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Выбор алфавита
            System.out.print("Введите алфавит (или оставьте пустым для латиницы): ");
            String customAlphabet = scanner.nextLine();

            CaesarCipher cipher;
            if (!customAlphabet.isEmpty()) {
                cipher = new CaesarCipher(customAlphabet);
            } else {
                cipher = new CaesarCipher();
            }

            // Запрос текста у пользователя
            System.out.print("Введите текст для шифрования: ");
            String text = scanner.nextLine();

            // Запрос величины сдвига у пользователя
            System.out.print("Введите величину сдвига: ");
            int shift = scanner.nextInt();

            // Шифрование текста
            String encrypted = cipher.encrypt(text, shift);
            System.out.println("Зашифрованный текст: " + encrypted);

            // Расшифровка текста
            String decrypted = cipher.decrypt(encrypted, shift);
            System.out.println("Расшифрованный текст: " + decrypted);

            // Выполнение брутфорс расшифровки
            cipher.bruteForceDecrypt(encrypted);
        }}


