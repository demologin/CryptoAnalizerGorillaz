package com.javarush.karpeev.util;

import java.nio.file.Path;

public class PathBuilder {
    private PathBuilder(){
    }
public static Path getPath(String nameFile){
    Path path = Path.of(nameFile);
    return path;
}
public static Path writePath(String file){
        Path path2 = Path.of(file);
        return path2;
    }


}
