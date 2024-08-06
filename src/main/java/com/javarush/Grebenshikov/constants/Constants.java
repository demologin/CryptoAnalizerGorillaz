package com.javarush.Grebenshikov.constants;


import java.util.HashMap;
import java.util.Map;

public class Constants {
    public static final String ALPHABET = "ЁЙЦУКЕНГШЩЗХЪФЫВАПРОЛДЖЭЯЧСМИТЬБЮ!@#$%^&*(){}[]';:_-+=?<>,.йцукенгшщзхъэждлорпавыфячсмитьбюё";


    public static final Map<Character, Integer> ALPHABET_MAP = new HashMap<>();


    static {
        for (int i = 0; i < ALPHABET.length(); i++) {
            ALPHABET_MAP.put(ALPHABET.charAt(i), i);
        }
    }
}

