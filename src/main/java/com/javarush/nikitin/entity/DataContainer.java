package com.javarush.nikitin.entity;

import com.javarush.nikitin.constants.InputParameter;
import com.javarush.nikitin.constants.Operation;
import com.javarush.nikitin.util.PathBuilder;

import java.nio.file.Path;

public record DataContainer(Operation type, Path source, Path destination, Path dictionary, int key) {
    public DataContainer {
        source = (source == null)
                ? PathBuilder.buildPath(InputParameter.SOURCE.getDefaultValue(type))
                : source;

        destination = (destination == null)
                ? PathBuilder.buildPath(InputParameter.DESTINATION.getDefaultValue(type))
                : destination;

        dictionary = (dictionary == null)
                ? PathBuilder.buildPath(InputParameter.DICTIONARY.getDefaultValue(type))
                : dictionary;

        key = (key == 1)
                ? InputParameter.KEY.getDefaultKeyAsInt()
                : key;
    }

    public DataContainer(Operation type, Path source, Path destination, int key) {
        this(type, source, destination, null, key);
    }

    public DataContainer(Operation type, Path source, Path destination, Path dictionary) {
        this(type, source, destination, dictionary, InputParameter.KEY.getDefaultKeyAsInt());
    }
}