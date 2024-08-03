package com.javarush.shosafoev.constant;

import com.javarush.shosafoev.command.Encode;
import com.javarush.shosafoev.controllers.File;
import com.javarush.shosafoev.controllers.Map;
import com.javarush.shosafoev.exceptions.FileNotExistsException;

import java.util.Scanner;

public class DataInputOutput {
    private final com.javarush.shosafoev.controllers.Map Map;

    public DataInputOutput() {
        Map = new Map();
    }


    public void dataInputOutput(String operationId) {
        String firstNameOfFile;
        String secondNameOfFile;
        String shift;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please input full path and name of 1 file: ");
        firstNameOfFile = scanner.nextLine();
        // check first file ---------------------------------------
        if (Map.isFileExists(firstNameOfFile)) {
            throw new FileNotExistsException("The file is not exist!");
        }

        System.out.print("Please input shift of coding/decoding (key): ");
        shift = scanner.nextLine();
        // check key (correct shift)
        Map.isValidKey(shift);

        System.out.print("Please input full path and name of 2 file: ");
        secondNameOfFile = scanner.nextLine();
        // check second file -------------------------------------
        Map.checkCorrectFilename(secondNameOfFile);
        Encode encoderDecoder = new Encode();
        // if menu item == "1" call encode method
        if (operationId.equals("1")) {
            // read first file
            File fileManager = new File();
            String text = fileManager.readFile(firstNameOfFile);
            // coding text
            String cryptText = encoderDecoder.encryptText(text, Integer.parseInt(shift));
            // write codding text to second file
            fileManager.writeFile(cryptText, secondNameOfFile);
        }
        // if menu item == "2" call decode method
        if (operationId.equals("2")) {
            // read first file
            File fileManager = new File();
            String text = fileManager.readFile(firstNameOfFile);
            // coding text
            String encryptText = encoderDecoder.decodeText(text);
            // write codding text to second file
            fileManager.writeFile(encryptText, secondNameOfFile);
        }
    }
}
