package com.javarush.karpeev;

import com.javarush.karpeev.command.Analyze;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Analyze analyze = new Analyze();
        int action = scanner.nextInt();
        if (action==1){
            analyze.alphToMap(analyze.arrChar);
        }
    }


}
