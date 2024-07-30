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

    public static synchronized Encode getEncode() {
        if (encode == null) {
            encode = new Encode();
        }
        return encode;
    }

    public static synchronized Decode getDecode() {
        if (decode == null) {
            decode = new Decode();
        }
        return decode;
    }

    public static synchronized BruteForce getBruteForce() {
        if (bruteForce == null) {
            bruteForce = new BruteForce();
        }
        return bruteForce;
    }
}


