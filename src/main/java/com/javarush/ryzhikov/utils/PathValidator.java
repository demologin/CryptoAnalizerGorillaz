package com.javarush.ryzhikov.utils;

import java.nio.file.Path;

public class PathValidator {

    //public static final String[] pathRestriction = {"log", "var", ""};

    public static boolean validate(String path) {


        if (path == null || (path.isBlank()) || (path.isEmpty())) return false;
        if (!Path.of(path).toAbsolutePath().startsWith("/home/")
                &&
                !Path.of(path).toAbsolutePath().startsWith("/tmp/")) return false;

        return true;


    }
}
