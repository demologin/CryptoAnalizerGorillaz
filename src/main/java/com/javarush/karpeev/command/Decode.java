package com.javarush.karpeev.command;

import com.javarush.karpeev.constant.Alphabet;

import java.util.ArrayList;
import java.util.Collections;


public class Decode {
    public static String[] execute(String text, int key) {
        ArrayList<Character> rotateAr = new ArrayList<>();
        rotateAr.addAll(Alphabet.characterAlphabed);
        Collections.rotate(rotateAr, key);
        char[] arrayText = text.toCharArray();
        for (int i = 0; i < arrayText.length; i++) {
            if (rotateAr.contains(arrayText[i])) {
                arrayText[i] = Alphabet.characterAlphabed.get(
                        rotateAr.indexOf(
                                arrayText[i]));
            }
        }
        Integer keyRes = key;
        return new String[]{new String(arrayText), keyRes.toString()};
    }
}
