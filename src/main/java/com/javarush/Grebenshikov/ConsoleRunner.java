package com.javarush.Grebenshikov;
import java.nio.file.Files;

public class ConsoleRunner {
    public static void main(String[] args) {
Application application = new Application();
NiceResult niceResult  = application.go(args) ;
        System.out.println(niceResult);
    }


}
