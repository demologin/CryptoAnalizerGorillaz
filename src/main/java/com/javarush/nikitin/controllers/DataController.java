package com.javarush.nikitin.controllers;

import com.javarush.nikitin.entity.DataContainer;
import com.javarush.nikitin.exceptions.ApplicationException;
import com.javarush.nikitin.useCase.*;
import com.javarush.nikitin.util.Validator;

public class DataController {
    private DataContainer dataContainer;
    private CryptologistCaesar cryptologist;

    public void setDataContainer(DataContainer dataContainer) {
        if (dataContainer == null) {
            throw new ApplicationException("DataContainer cannot be null");
        }
        this.dataContainer = dataContainer;
    }

    public void runProcessing() {
        Validator.validateData(dataContainer);
        createCaesarAlgorithm();
        processingData();
    }

    private void processingData() {
        DataProcessor processor = new DataProcessor(cryptologist);
        processor.push(dataContainer);
    }

    private void createCaesarAlgorithm() {
        cryptologist = switch (dataContainer.type()) {
            case ENCRYPT -> new EncrypterCaesar();
            case DECRYPT -> new DecrypterCaesar();
            case BRUTE_FORCE -> new BruteForceCaesar();
        };
    }


}