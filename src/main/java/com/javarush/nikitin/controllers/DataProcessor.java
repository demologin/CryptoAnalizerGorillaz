package com.javarush.nikitin.controllers;


import com.javarush.nikitin.entity.DataContainer;
import com.javarush.nikitin.exceptions.ApplicationException;
import com.javarush.nikitin.useCase.CryptologistCaesar;
import com.javarush.nikitin.util.PathBuilder;


import java.nio.file.Files;
import java.nio.file.Path;

public class DataProcessor {
    private final CryptologistCaesar cryptologist;

    DataProcessor(CryptologistCaesar cryptologist) {
        this.cryptologist = cryptologist;
    }

    void push(DataContainer data) {
        Path pathSource = PathBuilder.buildPath(data.source());
        Path pathDest = PathBuilder.buildPath(data.destination());
        try (var reader = Files.newBufferedReader(pathSource);
             var writer = Files.newBufferedWriter(pathDest)) {

            char[] buffer = new char[1024];
            int countRead;
            while ((countRead = reader.read(buffer)) > 0) {
                String request = String.valueOf(buffer, 0, countRead);
                String cryptResult = cryptologist.begin(request, data.key());
                writer.write(cryptResult);
            }
        } catch (Exception e) {
            throw new ApplicationException(e);
        }
    }
}
