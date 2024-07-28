package com.javarush.karpeev.util;

import com.javarush.karpeev.command.exception.InvalidException;

import java.util.Scanner;

public class ConsoleManager {
    public String[] readConsole() {


        Scanner scannerLine;
        String[] parametrs = new String[3];
        System.out.println("deystvie");
        scannerLine = new Scanner(System.in);
        String mod = scannerLine.nextLine();
        parametrs[0] = mod;
        if (mod.equals("1") || mod.equals("2")) {
            System.out.println("key?");
            String key = scannerLine.nextLine();
            if (key == null || Integer.parseInt(key) < 1 || key.isEmpty()) {
                System.out.println("значение ключа не корректно");

            }
            parametrs[2] = key;

        }
        System.out.println("adres?");
        String sourceString = scannerLine.nextLine();
        parametrs[1] = sourceString;
        if (mod == null || mod.isEmpty() || Integer.parseInt(mod) > 3 || Integer.parseInt(mod) < 0) {
            System.out.println("\"значение, \\\"Deystvie\\\" не корректно! (выбероите одно из допустимых знченией:\\\"0,1,2,3\\\" \"");

        }

        return parametrs;
    }
}
