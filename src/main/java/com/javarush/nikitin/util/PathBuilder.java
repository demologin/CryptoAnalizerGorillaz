package com.javarush.nikitin.util;

import java.io.File;
import java.nio.file.Path;

public class PathBuilder {
    private static final String DEFAULT_TEXT_FOLDER = System.getProperty("user.dir") +
            File.separator +
            "text" +
            File.separator;

    private PathBuilder() {
    }

    public static Path buildPath(String fileName) {
        Path path = Path.of(fileName);
        return path.isAbsolute()
                ? path
                : Path.of(DEFAULT_TEXT_FOLDER + fileName);
    }
}
