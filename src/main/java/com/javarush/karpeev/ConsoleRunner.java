package com.javarush.karpeev;

import com.javarush.karpeev.util.PathBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class ConsoleRunner {
    final static String ALPHABET = " .,!?;:йцукенгшщзхъфывапролдячсмить123456789@#$%^&*()\\/\"<>\\n";
    public static ArrayList<Character> characterArrayList = new ArrayList<>();
    static ArrayList<Character> rotateArraylist = new ArrayList<>();
    static int analyzeKey = 0;
    static String res;
    final static char SPACE = ' ';

    public static void main(String[] args) throws IOException {
        Scanner scannerInt = new Scanner(System.in);
        Scanner scannerLine = new Scanner(System.in);

        System.out.println("deystvie");
        int mod = scannerInt.nextInt();
        System.out.println("adres?");
        String sourceString = scannerLine.nextLine();
        String sourceList = Files.readString(PathBuilder.getPath(sourceString));
        System.out.println("key?");
        int key = scannerInt.nextInt();
        alphStrToMap(characterArrayList, ALPHABET);
        rotateAlphabet(characterArrayList, rotateArraylist, key);
        switch (mod) {
            case 1:
                res = encode(sourceList);
                Files.writeString(PathBuilder.writePath("D:\\java\\Pr\\rasskaz\\shifrStore.txt"), res);
                break;

            case 2:
                res = decode(sourceList);
                Files.writeString(PathBuilder.writePath("D:\\java\\Pr\\rasskaz\\decode.txt"), res);
                break;

            case 3:
                res = analyze(sourceList);
                Files.writeString(PathBuilder.writePath("D:\\java\\Pr\\rasskaz\\decode.txt"), res);
                System.out.println(analyzeKey);
                break;
        }


    }

    public static void alphStrToMap(ArrayList list, String alpabet) {

        char[] arrChar = alpabet.toCharArray();
        for (int i = 0; i < arrChar.length; i++) {
            list.add(arrChar[i]);
        }
    }

    public static ArrayList rotateAlphabet(ArrayList alphList, ArrayList rotateArraylist, int key) {

        rotateArraylist.addAll(alphList);
        Collections.rotate(rotateArraylist, key);
        return rotateArraylist;

    }

    public static String encode(String text) {
        char[] arrayText = text.toCharArray();
        for (int i = 0; i < arrayText.length; i++) {
            if (characterArrayList.contains(arrayText[i])) {
                arrayText[i] = rotateArraylist.get(characterArrayList.indexOf(arrayText[i]));
            }
        }
        return new String(arrayText);
    }

    public static String decode(String text) {
        char[] arrayText = text.toCharArray();
        for (int i = 0; i < arrayText.length; i++) {
            if (rotateArraylist.contains(arrayText[i])) {
                arrayText[i] = characterArrayList.get(rotateArraylist.indexOf(arrayText[i]));
            }
        }
        return new String(arrayText);
    }

    public static String analyze(String string) {
        int counter = 0;


        char[] testArrayChar = {'.', ',', '!', '?'};


        ArrayList<Character>tempArList = new ArrayList<>();
        tempArList.addAll(characterArrayList);





        for (int a = 0; a < rotateArraylist.size()+1; a++) {
            Collections.rotate(rotateArraylist, 1);
            char[] arrayChar = string.toCharArray();
            for (int i = 0; i < arrayChar.length; i++) {

                        if (characterArrayList.contains(arrayChar[i])) {
                            arrayChar[i] = characterArrayList.get(rotateArraylist.indexOf(arrayChar[i]));
                            //                            arrayChar[i] = characterArrayList.get(rotateArraylist.indexOf(arrayChar[i]));
                        }

            }


            for (int i = 0; i < arrayChar.length - 1; i++) {


                for (int j = 0; j < testArrayChar.length; j++) {
                    if (testArrayChar[j] == (arrayChar[i]) && arrayChar[i + 1] == SPACE) {
                        counter++;
                    }

                }
                if (counter > arrayChar.length/40) {
                    return new String(arrayChar);
                }
            }
            analyzeKey++;
            counter=0;
        }
        return null;
    }

    }


