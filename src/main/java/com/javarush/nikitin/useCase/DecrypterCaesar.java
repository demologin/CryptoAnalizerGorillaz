package com.javarush.nikitin.useCase;

public class DecrypterCaesar extends CryptologistCaesar {

    @Override
    public String begin(String inputText, int key) {
        return super.begin(inputText, -key);
    }
}
