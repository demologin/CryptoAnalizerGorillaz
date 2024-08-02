package com.javarush.karpeev.constant;

import java.util.ArrayList;

public class Alphabet {
    public final static String ALPHABET = " .,!?;:ЁёЙЦУКЕНГШЩЗХЪФЫВАПРОЛДЖЭЯЧСМИТЬБЮйцукенгшщзхъфывапролдячсмитьбю123456789@#$%^&*()\\/\"<>";
    public static char[] arrayChars = ALPHABET.toCharArray();
    public static ArrayList<Character> characterAlphabed = new ArrayList<>();

    static {
        for (int i = 0; i < arrayChars.length; i++) {
            characterAlphabed.add(arrayChars[i]);
        }
    }
}
