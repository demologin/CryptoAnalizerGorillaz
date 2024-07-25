package com.javarush.karpeev.command;

import com.javarush.karpeev.ConsoleRunner;
import com.javarush.khmelov.constant.Alphabet;

import java.util.HashMap;
import java.util.Map;

public class Analyze   {
    final String  ALPHABET = "йцукенгшщзхъфывапролдячсмить123456789!@#$%^&*(),. \\/\"<>";

    Map<Character,Integer> mapAlph = new HashMap<>();
    public char[] arrChar = ALPHABET.toCharArray();


    public void alphToMap(char[] chars) {
        for (int i = 0; i <chars.length ; i++) {
            mapAlph.put(chars[i],i);
        }
    }


}
