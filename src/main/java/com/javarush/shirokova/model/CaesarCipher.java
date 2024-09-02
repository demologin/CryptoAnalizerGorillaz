package com.javarush.shirokova.model;

/**
 * Class for encrypting and decrypting text using the Caesar cipher.
 */
public class CaesarCipher implements Cipher {
    private final Alphabet alphabet;

    public CaesarCipher(Alphabet alphabet) {
        this.alphabet = alphabet;
    }

    @Override
    public String encrypt(String originalText, int key) {
        return process(originalText, key);
    }

    @Override
    public String decrypt(String originalText, int key) {
        return process(originalText, -key);
    }

    /**
     * Method for encrypting or decrypting text.
     *
     * @param originalText Text to process.
     * @param key          Processing key (positive for encryption, negative for decryption).
     * @return Processed text (encrypted or decrypted).
     */

    private String process(String originalText, int key) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < originalText.length(); i++) {
            Character originalChar = toLowerCase(originalText.charAt(i));
            int originalCharIndex = alphabet.getIndexOfChar(originalChar);
            if (originalCharIndex == -1) {
                result.append(originalChar);
            } else {
                int newCharIndex = (originalCharIndex + key) % alphabet.getSize();
                if (newCharIndex < 0) {
                    newCharIndex = alphabet.getSize() + newCharIndex;
                }
                result.append(alphabet.getCharByIndex(newCharIndex));
            }
        }
        return result.toString();
    }

    private Character toLowerCase(Character character) {
        return (character + "").toLowerCase().charAt(0);
    }
}