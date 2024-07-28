package com.javarush.borisov.logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Reader extends FindFreqChar {
   private static Path readFile;
    private static Path saveFile;
    private static String param;

//    public Reader(Path readFile, String param) {
//        this.readFile = readFile;
//        this.param = param;
//    }
//
//    public Reader(Path readFile, Path saveFile) {
//        this.readFile = readFile;
//        this.saveFile = saveFile;
//    }

    public static void changeSimbol(Path readFile, Path saveFile,String regex, String replacement) {
        int count = 1000;
        String line = "";

            try (BufferedReader reader = Files.newBufferedReader(readFile);
                 BufferedWriter writer = Files.newBufferedWriter(saveFile)) {
                while (reader.ready()) {
                    while (count > 0) {
                        line = reader.readLine() + "\n";
                        line = line.replaceAll(regex,replacement);
                        writer.write(line);
                        count--;
                    }
                    count = 1000;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        public static String read (Path readFile){
        String line = "";
            try (BufferedReader reader = Files.newBufferedReader(readFile)) {
                while (reader.ready()) {
                    line = line + reader.readLine() + "\n";

                }

                return line;

            } catch (IOException e) {
                e.printStackTrace();
            }

        return line;
    }
}
