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
    //з.ы.ы реализовать преобразование в текст - удалить!
    //з.ы. алфавит уже есть
    private String shiftText(String text, int shift) {
        StringBuilder result = new StringBuilder();
        int alphabetLength = alphabet.length();

        System.out.println("---------------------------------------------------------");
        System.out.printf("%-5s %-5s %-6s %-5s%n", "char", "ind", "newInd", "result");
        System.out.println("---------------------------------------------------------");

        //проходимся по каждому символу в тексте
        for (char character : text.toCharArray()) {
            int index = alphabet.indexOf(character);

            if (index != -1) {
                //новый индекс с учётом сдвига
                int newIndex = (index + shift + alphabetLength) % alphabetLength;
                result.append(alphabet.charAt(newIndex));
                //темп для теста - удалить
                System.out.printf("%-5c %-5d %-6d %-5c%n", character, index, newIndex, alphabet.charAt(newIndex));
            } else {
                //если символ не найден в алфавите, то не меняем его.
                //з.ы. удалить пробел из алфавита и левые символы
                result.append(character);
                //темп для теста - удалить
                System.out.printf("%-55c %-5s %-6s %-5c%n", character, "", "", character);
            }
        }
        return result.toString();
    }
}
