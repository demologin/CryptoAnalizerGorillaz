package com.javarush.Grebenshikov;
import com.javarush.Grebenshikov.Decode.Decode;
import com.javarush.Grebenshikov.Encode.Encrypt;
import com.javarush.Grebenshikov.Exit.Exit;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;
        do{
            System.out.println("Welcome to my Ceasar Encrypt.Make your choice");
            System.out.println("1 : Start Encrypt");
            System.out.println("2 : Start Decode");
            System.out.println("3 : Exit");
            command = scanner.nextLine();
            switch (command){
                case "1":
                    new Encrypt();
                     break;
                case "2":
                    new Decode();
                    break;
                case "3":
                    new Exit();
                    break;


                default:
                    throw new IllegalStateException("Unexpected value: " + command);
            }
        }
        while(!command.equals("3"));
        }

    }



