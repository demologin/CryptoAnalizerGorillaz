package com.javarush.nikitin.util;

import com.javarush.nikitin.constants.Alphabet;
import com.javarush.nikitin.entity.DataContainer;
import com.javarush.nikitin.exceptions.ApplicationException;

import java.nio.file.Files;
import java.nio.file.Path;

public class Validator {

    private Validator() {
    }

    public static void validateData(DataContainer dataContainer) {
        switch (dataContainer.type()) {
            case ENCRYPT, DECRYPT -> {
                isValidPath(dataContainer.source());
                isValidPath(dataContainer.destination());
                isValidKey(dataContainer.key());
            }
            case BRUTE_FORCE -> {
                isValidPath(dataContainer.source());
                isValidPath(dataContainer.destination());
                isValidPath(dataContainer.dictionary());
            }
        }
    }

    public static void isValidKey(int key) {
        if (!(key >= 0 && key < Alphabet.size())) {
            throw new ApplicationException("invalid key = " + key);
        }
    }

    private static void isValidPath(Path path) {
        if (!Files.exists(path)) {
            throw new ApplicationException("File not found " + path);
        }
    }


}
