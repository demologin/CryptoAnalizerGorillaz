package com.javarush.siberia.constants;

import java.io.File;

public class Constants {
    private static final String rus = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final String eng = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String num = "1234567890";
    private static final String cym = "!@#$%^&*()_+-=*/.,<>[]{};:'\" `~";

    public static final String ALPHABET = rus + rus.toLowerCase() + eng + eng.toLowerCase() + num + cym;

    public static final String TXT_FOLDER = System.getProperty("user.dir") + File.separator + "text" + File.separator;

    public static final String INPUT_FILE = TXT_FOLDER + "text.txt";
    public static final String ENCODED_FILE = TXT_FOLDER + "encoded.txt";
    public static final String DECODED_FILE = TXT_FOLDER + "decoded.txt";
    public static final int DEFAULT_SHIFT = 3;
}