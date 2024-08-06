package com.javarush.myasnikov.inputs;

import com.javarush.myasnikov.utilities.Command;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

import static com.javarush.myasnikov.utilities.Command.BRUTE_FORCE;

public class FileHandler {

    Path currentPath = null;
    private String getUserPath() {
        return Paths.get(System.getProperty("user.dir")).toAbsolutePath().toString();
    }

    private void createResoursesDirectory () {
        Path directoryPath = Paths.get(getUserPath() + "/src/main/resources/myasnikov");
        currentPath = directoryPath;
        File directory = new File(String.valueOf(directoryPath));
        if (!directory.exists() && directory.mkdirs()) {
            System.out.println("Directory successfully added: " + directory);
        }
    }

    public String getFilesList (Command command) {
        if (currentPath == null) {
            createResoursesDirectory();
        }
        Path path = Paths.get(currentPath.toUri());
        File[] files = path.toFile().listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().startsWith(command.toString())) {
                    return file.getAbsolutePath();
                }
            }
        }
        return null;
    }

    public String[] getFilesListForBruteForce () {
        if (currentPath == null) {
            createResoursesDirectory();
        }
        Path path = Paths.get(currentPath.toUri());
        File[] files = path.toFile().listFiles();
        String[] filesList = new String[files.length];

        for (int i = 0; i < files.length; i++) {
            if (files[i].getName().startsWith(BRUTE_FORCE.toString())) {
                filesList[i] = files[i].getAbsolutePath();
            }
        }
        return filesList;
    }

    public void writeFile (String text, String fileName) {
        createResoursesDirectory();
        Path filePath = Paths.get(currentPath + "/" + fileName + ".txt");
        try {
            if (Files.exists(filePath)) {
                Files.delete(filePath);
            }
            Files.write(filePath, text.getBytes());
            System.out.println("File written at: " + fileName);
        } catch (IOException e) {
            System.out.println("Error occured during creation: " + fileName + "at: " + filePath.toAbsolutePath());
            e.printStackTrace();
        }
    }

    public String getTextFromFile(String fileStringPath) {
        if (currentPath == null) {
            createResoursesDirectory();
        }
        try (BufferedReader br = new BufferedReader(new FileReader(fileStringPath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                return sb.toString();
            }
        } catch (IOException e) {
            e.printStackTrace(); // Обработка исключений
        }
        return null;
    }
}



