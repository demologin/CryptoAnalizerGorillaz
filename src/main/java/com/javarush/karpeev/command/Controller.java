package com.javarush.karpeev.command;

import com.javarush.karpeev.util.ConsoleManager;
import com.javarush.karpeev.util.FileManager;
import com.javarush.karpeev.util.PathBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Controller {
    public void doAction() throws IOException {
        String result;
        String[] analyze = new String[2];
        ConsoleManager consoleManager = new ConsoleManager();
        FileManager fileManager = new FileManager();
        String[] parametrs = consoleManager.readConsole();
        String fileText = fileManager.readFile(parametrs[1]);
        switch (Integer.parseInt(parametrs[0])) {
            case 1:
                result = Encode.execute(fileText, Integer.parseInt(parametrs[2]));
                Files.writeString(PathBuilder.writePath("D:\\java\\Pr\\rasskaz\\shifrStore.txt"), result);
                break;

            case 2:
                analyze = Decode.execute(fileText, Integer.parseInt(parametrs[2]));
                result = analyze[0];
                Files.writeString(PathBuilder.writePath("D:\\java\\Pr\\rasskaz\\decode.txt"), result);
                break;

            case 3:
                analyze = Analyze.execute(fileText);
                result = analyze[0];
                Files.writeString(PathBuilder.writePath("D:\\java\\Pr\\rasskaz\\decode.txt"), result);
                System.out.println(analyze[1]);
                break;
        }
    }


//    alphStrToMap(characterArrayList, ALPHABET);
//    rotateAlphabet(characterArrayList, rotateArraylist, key);




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
}
