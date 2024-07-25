package com.javarush.karpeev;

import com.javarush.karpeev.util.PathBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class ConsoleRunner {
    final static String  ALPHABET = "йцукенгшщзхъфывапролдячсмить123456789!@#$%^&*(),. \\/\"<>\\n";
    static  ArrayList<Character> arrayList = new ArrayList<>();
    static ArrayList <Character> rotateArraylist = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("deystvie");
        int mod = scanner.nextInt();

        String sourceString = "D:\\java\\Pr\\1\\src.txt";
        String sourceList = Files.readString(PathBuilder.getPath(sourceString));
        System.out.println("key?");
        int key = scanner.nextInt();
        alphStrToMap(arrayList,ALPHABET);
        rotateAlphabet(arrayList, rotateArraylist, key);
        switch (mod)  {
            case 1:

                String res = encode(sourceList);
                Files.writeString(PathBuilder.writePath("C:\\Pr\\1\\src.txt"),res);
                break;
            case 2:

                res = decode(sourceList);
                Files.writeString(PathBuilder.writePath("C:\\Pr\\1\\dest.txt"),res);


        }



    }
    public static void alphStrToMap(ArrayList list,String alpabet){

   char[] arrChar =  alpabet.toCharArray();
        for (int i = 0; i < arrChar.length ; i++) {
           list.add(arrChar[i]);
        }
    }
public static ArrayList rotateAlphabet (ArrayList alphList,ArrayList rotateArraylist, int key){

    rotateArraylist.addAll(alphList);
    Collections.rotate( rotateArraylist,key);
    return rotateArraylist;

}
public static String encode(String text){
    char[]arrayText = text.toCharArray();
    for (int i = 0; i <arrayText.length ; i++) {
        if (arrayList.contains(arrayText[i])){
            arrayText[i]=rotateArraylist.get(arrayList.indexOf(arrayText[i]));
        }
    }
        return new String(arrayText);
    }
public static String decode (String text){
    char[]arrayText = text.toCharArray();
    for (int i = 0; i <arrayText.length ; i++) {
        if (rotateArraylist.contains(arrayText[i])){
            arrayText[i]=arrayList.get(rotateArraylist.indexOf(arrayText[i]));
        }
    }
    return new String(arrayText);
}
}

