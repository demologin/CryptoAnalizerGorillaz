package com.javarush.shosafoev.constant;

import java.util.Map;
import java.util.TreeMap;

public class Alphabet {
    // Number of letters - 32
    // Number of service symbols (space, '«', '»', '"'... ) - 10 (at the end)
    // Total number of symbols - 42

    public Alphabet() {
        Map<Integer, Character> alphabetMap = new TreeMap<>();
        int counter = 0;
        char[] alphabet = new char[]{'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
                'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
                'ъ', 'ы', 'ь', 'э', 'ю', 'я',
                '.', ',', '«', '»', '"', '\n', ':', '!', '?', ' '};
        for (char symbol : alphabet) {
            alphabetMap.put(counter, symbol);
            counter++;
        }
    }

    public int length() {
        return 0;
    }

    public int getIndexByValue() {
        return 0;
    }



    public char getSymbolByIndex() {
        return 0;
    }

    public boolean isSymbolExists(char symbol) {

        return false;
    }

    public char getSymbolByIndex(int i) {

        return 0;
    }
}