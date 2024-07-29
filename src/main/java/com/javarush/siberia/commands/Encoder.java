package com.javarush.siberia.commands;

import com.javarush.siberia.cipher.CaesarCipher;
import com.javarush.siberia.constants.Constants;
import com.javarush.siberia.entity.Result;
import com.javarush.siberia.entity.ResultCode;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Encoder implements Action{

    private final CaesarCipher cipher = new CaesarCipher();

    @Override
    public Result execute(String[] parameters) {

        int shift = Constants.DEFAULT_SHIFT;

        if (parameters.length > 0) {
            try {
                shift = Integer.parseInt(parameters[0]);
            } catch (NumberFormatException e) {
                return new Result("Сдвиг нужно ввести цифрами!", ResultCode.ERROR);
            }
        }

        char[] text;
        try {
            text = readFile(Constants.INPUT_FILE);
        } catch (IOException e) {
            return new Result("Не могу прочитать файл", ResultCode.ERROR);
        }

        char[] encryptedText = cipher.encrypt(text, shift);

        try {
            writeFile(Constants.ENCODED_FILE, encryptedText);
        } catch (IOException e) {
            return new Result("Ошибка записи в файл", ResultCode.ERROR  );
        }
        return new Result(new String(encryptedText), ResultCode.OK);
    }

    private char[] readFile(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName))).toCharArray();
    }

    private void writeFile(String fileName, char[] content) throws IOException {
        Files.write(Paths.get(fileName), new String(content).getBytes());
    }
}