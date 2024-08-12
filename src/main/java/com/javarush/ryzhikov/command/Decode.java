package com.javarush.ryzhikov.command;

import com.javarush.ryzhikov.dictionary.Alphabet;
import com.javarush.ryzhikov.entity.Result;
import com.javarush.ryzhikov.entity.ResultCode;

import java.io.*;

public class Decode implements Action{
    @Override
    public Result execute(String[] args) {
        try {
            String filePathEncoded = args[0];
            String filePathDecoded = args[1];
            int key = Integer.valueOf(args[2]);


            char[] charBuffer = new char[1024 * 4];
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePathEncoded));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePathDecoded));
            while (bufferedReader.ready()) {
                int charBufferFilledLength = bufferedReader.read(charBuffer);
                for (int i = 0; i < charBufferFilledLength; i++) {
                    char character = Character.toLowerCase(charBuffer[i]);

                    if (Alphabet.isExists(character)) {
                        int index = Alphabet.getIndex(character);
                        // charBuffer[i] = Alphabet.getCharacter((index + key) % Alphabet.ALPHABET_LENGTH);
                        charBuffer[i] = Alphabet.getCharacter((index - key) % Alphabet.ALPHABET_LENGTH);
                    }

                }
                bufferedWriter.write(charBuffer, 0, charBufferFilledLength);
            }

            bufferedReader.close();
            bufferedWriter.close();

            return new Result("encode finished ok ", ResultCode.OK);
        } catch (RuntimeException ex) {
            ex.printStackTrace();
            return new Result("encode finished ", ResultCode.ERROR);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
