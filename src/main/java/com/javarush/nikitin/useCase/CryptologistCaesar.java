package com.javarush.nikitin.useCase;

import com.javarush.nikitin.constants.Alphabet;

public abstract class CryptologistCaesar {

    public String begin(String inputText, int key) {
        char[] temp = inputText.toLowerCase().toCharArray();
        for (int i = 0; i < temp.length; i++) {
            int oldIndexChar = Alphabet.getIndex(temp[i]);
            if(oldIndexChar < 0){
                continue;
            }
            int newIndex = (oldIndexChar + key + Alphabet.size()) % Alphabet.size();
            char newChar = Alphabet.getChar(newIndex);
            temp[i] = newChar;
        }
        return String.valueOf(temp);
    }
}
