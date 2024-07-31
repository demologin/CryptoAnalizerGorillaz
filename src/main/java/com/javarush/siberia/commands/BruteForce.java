package com.javarush.siberia.commands;

import com.javarush.siberia.cipher.CaesarCipher;
import com.javarush.siberia.constants.Constants;
import com.javarush.siberia.entity.Result;
import com.javarush.siberia.entity.ResultCode;
import com.javarush.siberia.utils.DictionaryLoader;
import com.javarush.siberia.utils.FileReadWrite;

import java.io.IOException;
import java.util.Set;

public class BruteForce implements Action{

    private final CaesarCipher cipher = new CaesarCipher();

    private final Set<String> ruWords;
    private final Set<String> enWords;

    public BruteForce() {
        try {
            ruWords = DictionaryLoader.loadDictionary(Constants.RU_DICTIONARY_PATH);
            enWords = DictionaryLoader.loadDictionary(Constants.EN_DICTIONARY_PATH);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка загрузки словаря. Возможно файл отсутствует или повреждён", e);
        }
    }

    @Override
    public Result execute(String[] parameters) {

        char[] text;
        try {
            text = FileReadWrite.readFile(Constants.ENCODED_FILE);
        } catch (IOException e) {
            return new Result("Не могу прочитать файл", ResultCode.ERROR);
        }

        for (int shift = 0; shift < Constants.ALPHABET.length; shift++) {
            char[] bruteforcedText = cipher.decrypt(text, shift);

            if(isMeaningful(bruteforcedText, ruWords) || isMeaningful(bruteforcedText, enWords)) {
                try {
                    FileReadWrite.writeFile(Constants.BRUTEFORCE_FILE, bruteforcedText);
                } catch (IOException e) {
                    return new Result("Ошибка записи в файл", ResultCode.ERROR);
                }
                int correctShift = shift + 1; //это костыль =(
                System.out.println("Удалось взломать зашифрованный текст с ключом сдвига: " + correctShift);

                return new Result(new String(bruteforcedText), ResultCode.OK);
            }
        }
        return new Result("Не удалось понять шифрованый текст, я всего лишь алгоритм. Прикрути мне ИИ!", ResultCode.ERROR);
    }

    private boolean isMeaningful(char[] text, Set<String> dictionary) {
        String[] words = new String(text).split("\\W+");
        int meaningfulWordCount = 0;

        for (String word : words) {
            if (dictionary.contains(word.toLowerCase())) {
                meaningfulWordCount++;
            }
        }
        return  meaningfulWordCount > words.length * 0.8;
    }

}