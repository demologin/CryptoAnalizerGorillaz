package com.javarush.ryzhikov.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManager {
    public static InputStream readFile(String filePath) throws IOException {
        return Files.newInputStream(Path.of(filePath));
    }

    public static void writeFile(String filePath, OutputStream content) throws IOException {
//        BufferedWriter bufferedWriter =  Files.newBufferedWriter();
//        bufferedWriter.write();


    }


}
