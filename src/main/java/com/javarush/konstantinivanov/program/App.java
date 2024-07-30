package com.javarush.konstantinivanov.program;

import com.javarush.konstantinivanov.command.Command;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Command encode = Command.ENCODE;
        Command decode = Command.DECODE;
        Command exit = Command.EXIT;
        System.out.println("Введите название или номер команды:");
        System.out.println("1." + encode);
        System.out.println("2." + decode);
        System.out.println("3." + exit);

        Scanner input = new Scanner(System.in);
        String command = input.nextLine();



            while (true){
        if (command.toUpperCase().equals(encode.toString()) || command.equals("1")) {
            System.out.println("Код закодирован");
            break;
        } else if (command.toUpperCase().equals(decode.toString()) || command.equals("2")) {
            System.out.println("Код раскодирован");
            break;
        } else if (command.toUpperCase().equals(exit.toString()) || command.equals("3")) {
            System.out.println("Выйти из программы");
            break;
        } else {
            System.out.println("Комманда введена неверна, попробуйте снова");
            break;
        }}

    }


    }

