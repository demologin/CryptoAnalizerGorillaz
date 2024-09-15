package com.javarush.myasnikov.utilities;

public class Alphabet {
    private static final String RU_ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private static final String ENG_ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final String SPECIALS = ",. ";
    private static final String NUMBERS = "0123456789";
    public static final String ALPHABET = RU_ALPHABET + ENG_ALPHABET + SPECIALS + NUMBERS;
}
