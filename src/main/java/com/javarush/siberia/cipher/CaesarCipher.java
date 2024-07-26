package com.javarush.siberia.cipher;

import com.javarush.siberia.constants.Constants;

public class CaesarCipher {

    private final String alphabet = Constants.ALPHABET;

    public String encrypt(String text, int shift) {
        return shiftText(text, shift);
    }

    public String decrypt(String text, int shift) {
        return shiftText(text, -shift);
    }

    //метод для сдвига текста на заданное количество позиций
    private String shiftText(String text, int shift) {
        StringBuilder result = new StringBuilder();
        int alphabetLength = alphabet.length();

        //проходимся по каждому символу в тексте
        for (char character : text.toCharArray()) {
            int index = alphabet.indexOf(character);

            if (index != -1) {
                //новый индекс с учётом сдвига
                int newIndex = (index + shift + alphabetLength) % alphabetLength;
                result.append(alphabet.charAt(newIndex));
            } else {
                //если символ не найден в алфавите, то не меняем его.
                result.append(character);
            }
        }
        return result.toString();
    }
}
