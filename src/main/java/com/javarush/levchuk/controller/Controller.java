package com.javarush.levchuk.controller;

import com.javarush.levchuk.mods.BruteForce;
import com.javarush.levchuk.mods.Decode;
import com.javarush.levchuk.mods.Encode;
import com.javarush.levchuk.view.ProgramMessages;

public class Controller {
    private static Encode encode;
    private static Decode decode;
    private static BruteForce bruteForce;

    public ProgramMessages programMessages;

    public Controller(ProgramMessages programMessages) {
        this.programMessages = programMessages;
    }

    public Encode getEncode() {
        if (encode == null) {
            encode = new Encode(programMessages);
        }
        return encode;
    }

    public Decode getDecode() {
        if (decode == null) {
            decode = new Decode(programMessages);
        }
        return decode;
    }

    public BruteForce getBruteForce() {
        if (bruteForce == null) {
            bruteForce = new BruteForce(programMessages);
        }
        return bruteForce;
    }
}


