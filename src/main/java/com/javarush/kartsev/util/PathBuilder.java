package com.javarush.kartsev.util;

import com.javarush.kartsev.constant.Constans;

import java.nio.file.Path;

public class PathBuilder {

    private PathBuilder(){
    }
    public static Path get(String filename){
        Path path = Path.of(filename);
        return path.isAbsolute()
                ? path
                : Path.of(Constans.TXT_FOLDER + filename);
    }
}
