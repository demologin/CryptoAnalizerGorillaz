package com.javarush.borisov.logic.Analyse;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Reader {

    public String read(Path pathToReadFile){
        String line="";
        try(BufferedReader reader = Files.newBufferedReader(pathToReadFile)){
            while (reader.ready()){
                line = line + reader.readLine().toLowerCase();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return line;
    }
}
