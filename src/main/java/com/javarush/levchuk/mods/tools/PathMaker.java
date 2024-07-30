package com.javarush.levchuk.mods.tools;

import java.nio.file.Path;
import java.util.Scanner;

import static com.javarush.levchuk.constant.UtilConstants.DEFAULT_FOLDER;

public  class PathMaker {

    public static Path makePath(String defaultName) {
        Scanner scanner = new Scanner(System.in);
        String enterName = scanner.nextLine();
        Path path = Path.of(DEFAULT_FOLDER + defaultName);
        if (!enterName.equals("")) {
            Path userPath = Path.of(enterName);
            if (userPath.isAbsolute()) {
                path = userPath;
            } else {
                path = Path.of(DEFAULT_FOLDER + enterName);
            }
        }
        return path;
    }
}


