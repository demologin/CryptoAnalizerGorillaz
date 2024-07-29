package com.javarush.siberia.commands;

import com.javarush.siberia.cipher.CaesarCipher;
import com.javarush.siberia.constants.Constants;
import com.javarush.siberia.entity.Result;
import com.javarush.siberia.entity.ResultCode;
import com.javarush.siberia.utils.FileReadWrite;

import java.io.IOException;

public class Decoder implements Action{

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
            text = FileReadWrite.readFile(Constants.ENCODED_FILE);
        } catch (IOException e) {
            return new Result("Не могу прочитать файл", ResultCode.ERROR);
        }

        char[] decryptedText = cipher.decrypt(text, shift);

        try {
            FileReadWrite.writeFile(Constants.DECODED_FILE, decryptedText);
        } catch (IOException e) {
            return new Result("Не могу записать в файл", ResultCode.ERROR);
        }

        return new Result(new String(decryptedText), ResultCode.OK);
    }
}