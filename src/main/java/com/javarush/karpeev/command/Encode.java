package com.javarush.karpeev.command;

import com.javarush.karpeev.constant.Alphabet;
import com.javarush.karpeev.constant.Messages;

import java.util.ArrayList;
import java.util.Collections;

public class Encode {
    public static String execute(String text, int key) {
        ArrayList<Character> sniffedAlphabed = new ArrayList<>();
        sniffedAlphabed.addAll(Alphabet.characterAlphabed);
        Collections.rotate(sniffedAlphabed, key);
        char[] arrayText = text.toCharArray();
        for (int i = 0; i < arrayText.length; i++) {
            if (Alphabet.characterAlphabed.contains(arrayText[i])) {
                arrayText[i] = sniffedAlphabed.get(Alphabet.characterAlphabed.indexOf(arrayText[i]));
            }
        }

        return new String(arrayText);
    }
}
