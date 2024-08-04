package com.javarush.nikitin.util;

import com.javarush.nikitin.constants.Alphabet;
import com.javarush.nikitin.exceptions.ApplicationException;

import java.nio.file.Files;
import java.nio.file.Path;

public class Validator {

    private Validator() {
    }

    public static void isValidKey(int key) {
        if (!(key >= 0 && key < Alphabet.size())) {
            throw new ApplicationException("invalid key = " + key);
        }
    }

    public static void isValidPath(String path) {
        Path buildPath = PathBuilder.buildPath(path);
        if (!Files.exists(buildPath)) {
            throw new ApplicationException("File not found " + path);
        }
    }


}
