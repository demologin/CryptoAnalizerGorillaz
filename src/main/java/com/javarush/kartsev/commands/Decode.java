package com.javarush.kartsev.commands;

import com.javarush.kartsev.entity.Result;

public class Decode extends AbstractAction {
    @Override
    public Result execute(String[] parameters) {
        String encryptedFilename = parameters[0];
        String decryptedFilename = parameters[1];
        int key = Integer.parseInt(parameters[2]);
        return copyWithKey(encryptedFilename, decryptedFilename, -1 * key);
    }
}
