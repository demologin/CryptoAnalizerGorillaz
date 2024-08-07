package com.javarush.nikitin.controllers;

import com.javarush.nikitin.constants.Operation;
import com.javarush.nikitin.entity.DataContainer;
import com.javarush.nikitin.exceptions.ApplicationException;
import com.javarush.nikitin.useCase.BruteForceCaesar;
import com.javarush.nikitin.useCase.CryptologistCaesar;
import com.javarush.nikitin.util.PathBuilder;
import java.nio.file.Files;
import java.nio.file.Path;

public class DataProcessor {
    private final CryptologistCaesar cryptologist;

    DataProcessor(CryptologistCaesar cryptologist) {
        this.cryptologist = cryptologist;
    }

    public void executeDataOperation(DataContainer data) {
        Path pathSource = PathBuilder.buildPath(data.source());
        Path pathDestination = PathBuilder.buildPath(data.destination());

        if (data.type() == Operation.BRUTE_FORCE) {
            Path pathDictionary = PathBuilder.buildPath(data.dictionary());
            int bestKey = ((BruteForceCaesar) cryptologist).findBestKey(pathSource, pathDictionary);
            writeEncryptedData(pathSource, pathDestination, bestKey);
        } else {
            writeEncryptedData(pathSource, pathDestination, data.key());
        }
    }

    private void writeEncryptedData(Path pathSource, Path pathDest, int key) {
        try (var reader = Files.newBufferedReader(pathSource);
             var writer = Files.newBufferedWriter(pathDest)) {

            char[] buffer = new char[1024];
            int countRead;
            while ((countRead = reader.read(buffer)) > 0) {
                String request = String.valueOf(buffer, 0, countRead);
                String cryptResult = cryptologist.begin(request, key);
                writer.write(cryptResult);
            }
        } catch (Exception e) {
            throw new ApplicationException(e);
        }
    }
}
