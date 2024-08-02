package com.javarush.karpeev.util;

import com.javarush.karpeev.command.exception.InvalidException;
import com.javarush.karpeev.constant.Alphabet;
import com.javarush.karpeev.constant.Messages;

import java.util.Scanner;

public class ConsoleManager extends InvalidException {
    public String[] readConsole() {


        Scanner scannerLine;
        String[] parametrs = new String[4];
        scannerLine = new Scanner(System.in);
        String mod = null;
        boolean mode = false;


        while (!mode) {
        try {
            System.out.println(Messages.SELECTMODE);
            mod = scannerLine.nextLine();
            if (mod.equals("0")) {
                return new String[]{Messages.APPEXIT};

            }
            if (Integer.parseInt(mod) > 3 || Integer.parseInt(mod) < 0) {
                System.out.println(Messages.MODISINCORRECT);
               // mod == null || mod.isEmpty() ||

            } else {
                parametrs[0] = mod;
                mode = true;
            }
        } catch (Exception e){
            System.out.println(Messages.MODISINCORRECT);
            }
        }

        if (mod.equals("1") || mod.equals("2")) {
            boolean correctKey = false;
            System.out.println(Messages.SELECTKEY + (Alphabet.ALPHABET.length() - 1));
            while (!correctKey) {
                try {


                    String key = scannerLine.nextLine();

                    if (key == null || Integer.parseInt(key) < 1 || key.isEmpty() || Integer.parseInt(key) > 93) {
                        System.out.println(Messages.INCORRECTKEY);

                    } else {
                        parametrs[2] = key;
                        correctKey = true;
                    }

                } catch (Exception e) {
                    System.out.println(Messages.INCORRECTKEY);
                }

            }
        }
        boolean correctInput = false;
        String fileText;
        while (!correctInput) {
            System.out.println(Messages.INPUTSOURCEFILE);

            try {
                String sourceString = scannerLine.nextLine();
                FileController fileManager = new FileController();
                fileText = fileManager.readFile(sourceString);
            } catch (Exception e) {
                System.out.println(Messages.INCORRECTINPUTADRES);
                continue;

            }
            parametrs[1] = fileText;
            correctInput = true;

        }
        System.out.println(Messages.INPUTDESTINATIONFILE);
        correctInput = false;
        String adresToWrite = null;
        while (!correctInput) {
            try{
            adresToWrite = scannerLine.nextLine();
            if (adresToWrite.substring(adresToWrite.length() - 3).equals(".txt")) {
                System.out.println(Messages.INCORRECTINPUTADRES);
                continue;
            }
                parametrs[3] = adresToWrite;
                correctInput = true;
        }
        catch(Exception e) {
            System.out.println(Messages.INCORRECTINPUTADRES);
            }
        }
        return parametrs;
    }
}
