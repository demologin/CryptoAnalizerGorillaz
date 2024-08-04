package com.javarush.nikitin.useCase;

import com.javarush.nikitin.exceptions.ApplicationException;

public class BruteForceCaesar extends CryptologistCaesar {

    @Override
    //TODO
    public String begin(String inputText, int key) {
        throw new ApplicationException("Sorry, implementation expected");
    }
}
