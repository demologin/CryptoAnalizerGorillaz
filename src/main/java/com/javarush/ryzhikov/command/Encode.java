package com.javarush.ryzhikov.command;


import com.javarush.ryzhikov.dictionary.Alphabet;
import com.javarush.ryzhikov.entity.Result;
import com.javarush.ryzhikov.entity.ResultCode;

import java.io.*;
import java.util.Scanner;

public class Encode implements Action {

    public Result execute(String[] args) {
        try {
            String filePathDecoded = args[0];
            String filePathEncoded = args[1];
            int key = Integer.valueOf(args[2]);

            char[] charBuffer = new char[1024 * 4];
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePathDecoded));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePathEncoded));
            while (bufferedReader.ready()) {
                int charBufferFilledLength = bufferedReader.read(charBuffer);
                for (int i = 0; i < charBufferFilledLength; i++) {
                    char character = Character.toLowerCase(charBuffer[i]);

                    if (Alphabet.isExists(character)) {
                        int index = Alphabet.getIndex(character);
                        charBuffer[i] = Alphabet.getCharacter((index + key) % Alphabet.ALPHABET_LENGTH);
                    }

                }
                bufferedWriter.write(charBuffer, 0, charBufferFilledLength);
            }

            bufferedReader.close();
            bufferedWriter.close();

//            FileChannel fileChannel = new RandomAccessFile(filePathDecoded, "r").getChannel();
//            ByteBuffer byteBuffer = ByteBuffer.allocate(4 * 1024);
//
////        byte[] bytes = new byte[4 * 1024];
//            while (fileChannel.read(byteBuffer) != -1) {
//                for (byte b : byteBuffer.array()) {
//                    b = (byte) ((Alphabet.ALPHABET_LENGTH + key) % Alphabet.ALPHABET_LENGTH);
//                    byteBuffer.get(b);
//                }
//            }
//            fileChannel.read(byteBuffer);
//            //ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(filePathDecoded.);
//
//
//            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//            //    byteArrayOutputStream.write();
//
//


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

//    public boolean checkSimbolExistsInDictionnary(char c) {
//        return Alphabet.isExists(c);
//    }
}
