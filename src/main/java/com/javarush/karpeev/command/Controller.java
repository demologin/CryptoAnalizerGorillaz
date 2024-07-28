package com.javarush.karpeev.command;

import com.javarush.karpeev.util.ConsoleManager;
import com.javarush.karpeev.util.FileManager;
import com.javarush.karpeev.util.PathBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Controller {
    public void doAction() throws IOException {
        String result;
        String[] analyze = new String[2];
        boolean test = false;
        String[] parametrs = new String[3];
        String fileText = null;
        while (!test) {
            try {
                ConsoleManager consoleManager = new ConsoleManager();
                FileManager fileManager = new FileManager();
                parametrs = consoleManager.readConsole();
                fileText = fileManager.readFile(parametrs[1]);

                test = true;
            }catch (Exception e){
                System.out.println("test"+""+ e);
            }
            }
        switch (Integer.parseInt(parametrs[0])) {
            case 1:
                result = Encode.execute(fileText, Integer.parseInt(parametrs[2]));
                Files.writeString(PathBuilder.writePath("D:\\java\\Pr\\rasskaz\\shifrStore.txt"), result);
                break;

            case 2:
                analyze = Decode.execute(fileText, Integer.parseInt(parametrs[2]));
                result = analyze[0];
                Files.writeString(PathBuilder.writePath("D:\\java\\Pr\\rasskaz\\decode.txt"), result);
                break;

            case 3:
                analyze = Analyze.execute(fileText);
                result = analyze[0];
                Files.writeString(PathBuilder.writePath("D:\\java\\Pr\\rasskaz\\decode.txt"), result);
                System.out.println(analyze[1]);
                break;

        }

    }
}
