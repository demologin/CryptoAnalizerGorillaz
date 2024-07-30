package com.javarush.siberia.constants;

import java.io.File;

public class Constants {
    private static final String rus = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final String eng = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String num = "1234567890";
    private static final String cym = "!@#$%^&*()_+-=*/.,<>[]{};:'\" `~";

    public static final char[] ALPHABET = (rus + rus.toLowerCase() + eng + eng.toLowerCase() + num + cym).toCharArray();
    public static final String ALPHABET_LENGTH_TXT = "Текущая длина алфавита: " + ALPHABET.length + " символов.";

    public static final String DEFAULT_FOLDER = System.getProperty("user.dir") + File.separator + "text" + File.separator;

    public static final String INPUT_FILE = DEFAULT_FOLDER + "text.txt";
    public static final String ENCODED_FILE = DEFAULT_FOLDER + "encoded.txt";
    public static final String DECODED_FILE = DEFAULT_FOLDER + "decoded.txt";
    public static final String BRUTEFORCE_FILE = DEFAULT_FOLDER + "bruteForce.txt";
    public static final String RU_DICTIONARY_PATH = DEFAULT_FOLDER + "ru_words.txt";
    public static final String EN_DICTIONARY_PATH = DEFAULT_FOLDER + "en_words.txt";

    public static final int DEFAULT_SHIFT = 3;

    public static final String MENU_TXT = "\nВыберите действие:\n1. Шифровать\n2. Дешифровать\n3. Взлом.\n4. Анализ.\n5. Выйти.\nВведите выбранный пункт меню: ";
    public static final String ENCODE_TXT = "Введите путь к файлу для шифрования (или нажмите Enter для пути по умолчанию): ";
    public static final String DECODE_TXT = "Введите путь к файлу для дешифрования (или нажмите Enter для пути по умолчанию): ";
    public static final String OUTPUT_TXT = "Введите путь для сохранения результата (или нажмите Enter для использования пути по умолчанию): ";
    public static final String KEY_TXT = "Введите ключ (или нажмите Enter для сдвига по умолчанию - 3): ";
    public static final String INVALID_CHOICE_TXT = "Нет такого пункта, попробуйте снова.";
    public static final String EXIT_TXT = "Выход из программы...";
}