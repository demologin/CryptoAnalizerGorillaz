package com.javarush.adilkhan.utils;

import java.util.ArrayList;
import java.util.List;

public class Alphabet {

    public static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

    public final static List<Character> characterSet = new ArrayList<>();

    static {
        for (int i = 0; i < ALPHABET.length; i++) {
            characterSet.add(ALPHABET[i]);
        }
    }

}
