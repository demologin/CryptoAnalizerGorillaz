package com.javarush.karpeev.constant;

import java.util.ArrayList;
import java.util.Collections;

public  class Alphabet {
   public final static String ALPHABET = " .,!?;:ЁёЙЦУКЕНГШЩЗХЪФЫВАПРОЛДЖЭЯЧСМИТЬБЮйцукенгшщзхъфывапролдячсмитьбю123456789@#$%^&*()\\/\"<>";
   public static char[]arrayChars = ALPHABET.toCharArray();
   public static ArrayList<Character> characterArrayList = new ArrayList<>();

   static {
      for (int i = 0; i < arrayChars.length ; i++) {
         characterArrayList.add(arrayChars[i]);
      }
   }
   public static void rotateAlphabet(ArrayList list,int distance){
      Collections.rotate(list,distance);
   }
}
