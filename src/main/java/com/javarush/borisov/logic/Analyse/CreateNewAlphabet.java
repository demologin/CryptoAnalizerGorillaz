package com.javarush.borisov.logic.Analyse;


import java.util.HashMap;
import java.util.Map;

public class CreateNewAlphabet {

    public Map createNewAlphabet(Map<String, Integer> dicCast, Map<String,Integer> encryptCast) {
        Map<Character,Character> newAlphabet = new HashMap();
        while (dicCast.size() > 0 || encryptCast.size() > 0) {
            String keyDic = "";
            String keyEncrypt = "";
            int maxDic = Integer.MIN_VALUE;
            int maxEncrypt = Integer.MIN_VALUE;


            for (Map.Entry entry : dicCast.entrySet()) {
                if (Integer.parseInt(entry.getValue().toString()) > maxDic) {
                    keyDic = entry.getKey().toString();
                    maxDic = Integer.parseInt(entry.getValue().toString());
                }

            }
            System.out.println("пара в словаре = |" + keyDic + "|" + " частота встречи = |" + maxDic + "|");


            for (Map.Entry entry : encryptCast.entrySet()) {
                if (Integer.parseInt(entry.getValue().toString()) > maxEncrypt) {
                    keyEncrypt = entry.getKey().toString();
                    maxEncrypt = Integer.parseInt(entry.getValue().toString());
                }

            }
            System.out.println("пара в шифре = |" + keyEncrypt + "|" + " частота встречи = |" + maxEncrypt + "|");


            if(!keyDic.isEmpty() && !newAlphabet.containsKey(keyDic.charAt(0)) && !newAlphabet.containsValue(keyEncrypt.charAt(0))) {
                newAlphabet.put(keyDic.charAt(0), keyEncrypt.charAt(0));
            }
            if(!keyDic.isEmpty() && !newAlphabet.containsKey(keyDic.charAt(1)) && !newAlphabet.containsValue(keyEncrypt.charAt(1))) {
                newAlphabet.put(keyDic.charAt(1), keyEncrypt.charAt(1));
            }
            encryptCast.remove(keyEncrypt);
            dicCast.remove(keyDic);
        }
        System.out.println(newAlphabet);

        return newAlphabet;
    }
}
