package com.javarush.karpeev.command;

import com.javarush.karpeev.constant.Alphabet;

import java.util.ArrayList;
import java.util.Collections;

public class Encode {
    public static String execute(String text,int key) {
        ArrayList<Character> sniffedAlphabed = new ArrayList<>();
        sniffedAlphabed.addAll(Alphabet.characterArrayList);
        Collections.rotate(sniffedAlphabed,key);
        char[] arrayText = text.toCharArray();
        for (int i = 0; i < arrayText.length; i++) {
            if (Alphabet.characterArrayList.contains(arrayText[i])) {
                arrayText[i] = sniffedAlphabed.get(Alphabet.characterArrayList.indexOf(arrayText[i]));
            }
        }
        return new String(arrayText);
    }
}
