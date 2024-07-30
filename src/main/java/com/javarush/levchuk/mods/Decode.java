package com.javarush.levchuk.mods;

import com.javarush.levchuk.mods.tools.Coding;
import com.javarush.levchuk.mods.tools.PathMaker;
import com.javarush.levchuk.view.ProgramMessages;

import java.nio.file.Path;

import static com.javarush.levchuk.constant.UtilConstants.*;

public class Decode {
    public ProgramMessages messages;

    public Decode(ProgramMessages messages) {
        this.messages = messages;
    }

    public void runDecode() {
        messages.printfMessage(CONTEXT_MESSAGES[0], DEFAULT_ENCRYPT_FILE_NAME);
        Path source = PathMaker.makePath(DEFAULT_ENCRYPT_FILE_NAME);

        messages.printfMessage(CONTEXT_MESSAGES[1], DEFAULT_DECRYPT_FILE_NAME);
        Path target = PathMaker.makePath(DEFAULT_DECRYPT_FILE_NAME);

        messages.printfMessage(CONTEXT_MESSAGES[2], Integer.toString(DEFAULT_KEY));
        int key = Coding.enterKey();
        messages.printfMessage(Coding.processingToFile(source, target, -1 * key));

    }
}
