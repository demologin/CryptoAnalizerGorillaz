package com.javarush.siberia.constants;

public class Constants {
    private static final String rus = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final String eng = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String num = "1234567890";
    private static final String cym = "!@#$%^&*()_+-=*/.,<>[]{};:'\"\n `~";

    public static final String ALPHABET = rus + rus.toLowerCase() + eng + eng.toLowerCase() + num + cym;
}
