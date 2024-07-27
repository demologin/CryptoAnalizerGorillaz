package com.javarush.karpeev.command;

import com.javarush.karpeev.constant.Alphabet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Analyze {
    public static String[] execute(String stringText) {

        if (stringText.length() > 1000) {
            String thousandText = stringText.substring(0, 1000);
            int key = analyze(thousandText);
            String[] res = Decode.execute(stringText, key);
            return res;
        } else {
            int key = analyze(stringText);
            String[] res = Decode.execute(stringText, key);
            return res;
        }

    }

    public static int analyze(String incodeText) {
        int counterKeysSpace = 0;
        int tempCounterKeysSpace = 0;
        Integer key = 0;
        int analyzeKey = 1;
        char[] arrayCharText = incodeText.toCharArray();
        char[] testArrayChar = {'.', ',', '!', '?'};
        char[] tempArrayCharText = new char[incodeText.length()];
        ArrayList<Character> sniffedAlphabed = new ArrayList<>();
        sniffedAlphabed.addAll(Alphabet.characterArrayList);

        for (int i = 0; i < sniffedAlphabed.size(); i++) {
            Collections.rotate(sniffedAlphabed, 1);
            System.arraycopy(arrayCharText, 0, tempArrayCharText, 0, arrayCharText.length);
            /** Сравниваем с оригинальным алфавитом и присваимем элемент оригинального алфавита,
             под индексом такого же элемента в смещенном алфавите*/
            for (int j = 0; j < tempArrayCharText.length - 1; j++) {
                if (Alphabet.characterArrayList.contains(tempArrayCharText[j])) {
                    tempArrayCharText[j] = Alphabet.characterArrayList.get(sniffedAlphabed.indexOf(tempArrayCharText[j]));
                }
            }  /** Далее ниже будем анализировать изменeнный текст, циклом выше. Считать ситуации, когда
             * после знака препинания из цикла testArrayChar идет пробел. Ситуацию с лучшим показателем счетчика
             * counterKeysSpace считаем за правильный вариант текста*/


            for (int x = 0; x < tempArrayCharText.length - 2; x++) {


                for (int j = 0; j < testArrayChar.length; j++) {
                    if (testArrayChar[j] == (tempArrayCharText[x]) && tempArrayCharText[x + 1] == ' ') {
                        tempCounterKeysSpace++;
                    }

                }

            }

            if (tempCounterKeysSpace > counterKeysSpace ) {
                counterKeysSpace = tempCounterKeysSpace;
                key = analyzeKey;

            }

            analyzeKey++;
            tempCounterKeysSpace = 0;

        }
        return key;
    }
}

