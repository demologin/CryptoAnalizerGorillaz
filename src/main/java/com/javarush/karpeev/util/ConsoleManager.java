package com.javarush.karpeev.util;

import java.util.Scanner;

public class ConsoleManager {
    public String[] readConsole(){
        Scanner scannerLine = new Scanner(System.in);

        System.out.println("deystvie");
        String mod = scannerLine.nextLine();
        String[]parametrs = new String[3];
        parametrs[0]=mod;
        if (mod.equals("1")||mod.equals("2")){
            System.out.println("key?");
            String key = scannerLine.nextLine();
            parametrs[2]=key;
        }

        System.out.println("adres?");
        String sourceString = scannerLine.nextLine();
        parametrs[1] = sourceString;
        return parametrs;

    }

}
