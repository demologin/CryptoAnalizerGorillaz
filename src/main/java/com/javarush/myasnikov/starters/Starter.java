package com.javarush.myasnikov.starters;
import com.javarush.myasnikov.swingApp;
import com.javarush.myasnikov.console.ConsoleApp;

public class Starter {
    public static void main(String[] args) {
        switch ("ui") {
            case "console": new ConsoleApp();
            case "ui": new swingApp();
        }
    }
}
