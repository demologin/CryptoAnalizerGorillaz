package com.javarush.shirokova.model;

/**
 * Interface for implementing text encryption and decryption algorithms.
 */
public interface Cipher {
    /**
     * Method to encrypt text.
     *
     * @param text Text to encrypt.
     * @param key  Encryption key.
     * @return Encrypted text.
     */
    String encrypt(String text, int key);

    /**
     * Method to decrypt text.
     *
     * @param text Text to decrypt.
     * @param key  Decryption key.
     * @return Decrypted text.
     */
    String decrypt(String text, int key);
}