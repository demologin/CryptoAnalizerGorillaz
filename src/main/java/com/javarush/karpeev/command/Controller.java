package com.javarush.karpeev.command;

import com.javarush.karpeev.constant.Messages;
import com.javarush.karpeev.util.ConsoleManager;
import com.javarush.karpeev.util.FileController;
import com.javarush.karpeev.util.PathBuilder;

import java.io.IOException;
import java.nio.file.Files;

public class Controller {
    public void doAction() throws IOException {
        String result;
        String[] analyze;

        String[] parametrs;


        ConsoleManager consoleManager = new ConsoleManager();
        parametrs = consoleManager.readConsole();
        if (parametrs[0].equals(Messages.APPEXIT)) {
            System.out.println(Messages.APPEXIT);
            return;
        }


        switch (Integer.parseInt(parametrs[0])) {
            case 1:
                result = Encode.execute(parametrs[1], Integer.parseInt(parametrs[2]));
                FileController.writeFile(parametrs[3], result);


                break;

            case 2:
                analyze = Decode.execute(parametrs[1], Integer.parseInt(parametrs[2]));
                result = analyze[0];
                FileController.writeFile(parametrs[3], result);

                break;

            case 3:
                analyze = Analyze.execute(parametrs[1]);
                result = analyze[0];
                FileController.writeFile(parametrs[3], result);
                System.out.println(analyze[1]);

                break;
            case 0:
                System.out.println(Messages.APPEXIT);

        }

    }

}
