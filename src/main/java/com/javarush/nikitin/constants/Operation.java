package com.javarush.nikitin.constants;

import com.javarush.nikitin.exceptions.ApplicationException;

public enum Operation {
    ENCRYPT(1),
    DECRYPT(2),
    BRUTE_FORCE(3),
    ;

    private final int value;

    Operation(int value) {
        this.value = value;
    }

    public static Operation getInstance(int number) {
        for (Operation type : Operation.values()) {
            if (type.value == number) {
                return type;
            }
        }
        throw new ApplicationException("Invalid operation number: " + number);
    }
}