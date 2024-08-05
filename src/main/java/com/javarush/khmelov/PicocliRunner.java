package com.javarush.khmelov;

import com.javarush.khmelov.controller.MainController;
import com.javarush.khmelov.view.picocli.Picocli;
import com.javarush.khmelov.view.picocli.PicocliApp;
import picocli.CommandLine;

public class PicocliRunner {
    public static void main(String[] args) {
        //app build
        MainController mainController = new MainController();
        PicocliApp application = new PicocliApp(mainController);

        //run picocli
        Picocli command = new Picocli(application);
        CommandLine commandLine = new CommandLine(command);
        int exitCode = commandLine.execute(args);

        //return result
        System.exit(exitCode);
    }
}
