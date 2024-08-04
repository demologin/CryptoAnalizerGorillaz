package com.javarush.konstantinivanov.program;

import com.javarush.konstantinivanov.command.Command;
import com.javarush.konstantinivanov.command.CommandMethods;


import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        while (true) {
            Command encode = Command.ENCODE;
            Command decode = Command.DECODE;
            Command exit = Command.EXIT;


            System.out.println("Введите название или номер команды:");
            System.out.println("1." + encode);
            System.out.println("2." + decode);
            System.out.println("3." + exit);

            Scanner input = new Scanner(System.in);
            String command = input.nextLine();
            if (command.toUpperCase().equals(encode.toString()) || command.equals("1")) {
                CommandMethods.encode(input);
                break;
            } else if (command.toUpperCase().equals(decode.toString()) || command.equals("2")) {
                CommandMethods.decode(input);
                break;
            } else if (command.toUpperCase().equals(exit.toString()) || command.equals("3")) {
                CommandMethods.exit(input);
                break;
            } else {
                System.out.println("Введите корректный номер/название команды");
            }
        }
    }


}

