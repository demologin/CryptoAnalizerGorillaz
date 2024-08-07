package com.javarush.nikitin.entity;

import com.javarush.nikitin.constants.InputParameter;
import com.javarush.nikitin.constants.Operation;

public record DataContainer(Operation type, String source, String destination, String dictionary, int key) {
    public DataContainer {
        source = (source == null || source.isEmpty())
                ? InputParameter.SOURCE.getDefaultValue(type)
                : source;

        destination = (destination == null || destination.isEmpty())
                ? InputParameter.DESTINATION.getDefaultValue(type)
                : destination;

        dictionary = (dictionary == null || dictionary.isEmpty())
                ? InputParameter.DICTIONARY.getDefaultValue(type)
                : dictionary;

        key = (key == 1)
                ? InputParameter.KEY.getDefaultKeyAsInt()
                : key;
    }

    public DataContainer(Operation type, String source, String destination, int key) {
        this(type, source, destination, "", key);
    }

    public DataContainer(Operation type, String source, String destination, String dictionary) {
        this(type, source, destination, dictionary, InputParameter.KEY.getDefaultKeyAsInt());
    }

    //test
    public DataContainer(Operation type) {
        this(type, "", "", "", 0);
    }
}