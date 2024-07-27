package com.javarush.karpeev.util;

import java.io.IOException;
import java.nio.file.Files;

public class FileManager {
    public String readFile(String sourceString) throws IOException {
        String sourceList = Files.readString(PathBuilder.getPath(sourceString));
        return sourceList;
    }
}
