package com.javarush.siberia.constants;

import java.io.File;

public class Constants {
    private static final String rus = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final String eng = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String num = "1234567890";
    private static final String cym = "!@#$%^&*()_+-=*/.,<>[]{};:'\"\n `~";

    public static final String ALPHABET = rus + rus.toLowerCase() + eng + eng.toLowerCase() + num + cym;

    public static final String TXT_FOLDER = System.getProperty("user.dir") + File.separator + "text" + File.separator;
}