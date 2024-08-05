package com.javarush.borisov.logic.Analyse;

import java.util.HashMap;
import java.util.Map;

public class CreateAlphabetCast {


    public Map createAlphabetCast(String input) {
        Map<String, Integer> chars = new HashMap<>();
        for (int i = 0; i < input.length()-1; i++) {
            String key = input.charAt(i) + "" + input.charAt(i + 1);
            if(chars.containsKey(key)){
                chars.put(key,chars.get(key)+1);
            }else {
                chars.put(key,1);
            }
        }
        System.out.println(chars);


        return chars;
    }

}
