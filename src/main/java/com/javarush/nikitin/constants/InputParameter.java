package com.javarush.nikitin.constants;

public enum InputParameter {
    SOURCE("Enter file source OR default",
            "text.txt",
            "encrypted.txt",
            "encrypted.txt"),

    DESTINATION("Enter file destination OR default",
            "encrypted.txt",
            "decrypted.txt",
            "bruteforce.txt"),

    DICTIONARY("Enter file dictionary",
            "dictionary.txt",
            "dictionary.txt",
            "dictionary.txt"),

    KEY("",
            "1",
            "1",
            "1"),
    ;
    static {
        int maxKeyAlphabet = Alphabet.size() - 1;
        KEY.message = "Enter key from 0 to " + maxKeyAlphabet + " OR default";
    }

    private String message;
    private final String defaultEncrypt;
    private final String defaultDecrypt;
    private final String defaultBruteForce;

    InputParameter(String message, String defaultEncrypt, String defaultDecrypt, String defaultBruteForce) {
        this.message = message;
        this.defaultEncrypt = defaultEncrypt;
        this.defaultDecrypt = defaultDecrypt;
        this.defaultBruteForce = defaultBruteForce;
    }

    public String getMessage() {
        return message;
    }

    public int getDefaultKeyAsInt() {
        return Integer.parseInt(KEY.defaultEncrypt);
    }

    public String getDefaultValue(Operation type) {
        return switch (type) {
            case ENCRYPT -> defaultEncrypt;
            case DECRYPT -> defaultDecrypt;
            case BRUTE_FORCE -> defaultBruteForce;
        };
    }
}