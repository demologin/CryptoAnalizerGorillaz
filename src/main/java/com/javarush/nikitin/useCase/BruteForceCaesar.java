package com.javarush.nikitin.useCase;

import com.javarush.nikitin.constants.Alphabet;
import com.javarush.nikitin.entity.ModelLanguage;
import com.javarush.nikitin.exceptions.ApplicationException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BruteForceCaesar extends CryptologistCaesar {

    @Override
    public String begin(String inputText, int key) {
        return super.begin(inputText, -key);
    }

    public int findBestKey(Path pathSource, Path pathDictionary) {
        ModelLanguage referenceModel = buildReferenceModel(pathDictionary);
        ModelLanguage testModel = new ModelLanguage();
        int bestKey = 0;
        double minDifference = Double.MAX_VALUE;

        for (int i = 0; i < Alphabet.size(); i++) {
            try (var reader = Files.newBufferedReader(pathSource)) {
                char[] buffer = new char[1024];
                int countRead;

                while ((countRead = reader.read(buffer)) > 0) {
                    String request = String.valueOf(buffer, 0, countRead).toLowerCase();
                    String cryptResult = begin(request, i);
                    testModel.learn(cryptResult);
                }

                double currentDifference = ModelLanguage.isCompareModel(referenceModel, testModel);
                if (minDifference > currentDifference) {
                    minDifference = currentDifference;
                    bestKey = i;
                }
            } catch (IOException e) {
                throw new ApplicationException(e);
            }
            testModel.clear();
        }
        return bestKey;
    }

    private ModelLanguage buildReferenceModel(Path pathDictionary) {
        ModelLanguage referenceModel = new ModelLanguage();
        try (var reader = Files.newBufferedReader(pathDictionary)) {
            char[] buffer = new char[1024];
            int countRead;

            while ((countRead = reader.read(buffer)) > 0) {
                String request = String.valueOf(buffer, 0, countRead).toLowerCase();
                referenceModel.learn(request);
            }
        } catch (IOException e) {
            throw new ApplicationException(e);
        }
        return referenceModel;
    }
}
