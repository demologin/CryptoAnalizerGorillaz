package com.javarush.karpeev.util;

import java.io.IOException;
import java.nio.file.Files;

public class FileController {
    public String readFile(String sourceString) throws IOException {
        String sourceList = Files.readString(PathBuilder.getPath(sourceString));
        return sourceList;
    }
    public static void writeFile (String adresToWrite,String text) throws IOException {
        Files.writeString(PathBuilder.writePath(adresToWrite), text);
    }
}
