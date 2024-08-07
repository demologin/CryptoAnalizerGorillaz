package com.javarush.nikitin.entity;

import com.javarush.nikitin.exceptions.ApplicationException;

import java.util.HashMap;
import java.util.Map;

public class ModelLanguage {
    private final Map<String, Integer> wordCount;
    private int totalCount;

    public void clear() {
        wordCount.clear();
        totalCount = 0;
    }

    public ModelLanguage() {
        wordCount = new HashMap<>();
    }

    public void learn(String text) {
        String[] words = text.split("\\s+");
        for (String word : words) {
            String str = word.toLowerCase();
            wordCount.put(str, wordCount.getOrDefault(str, 0) + 1);
        }
    }


    public static double isCompareModel(ModelLanguage reference, ModelLanguage decrypted) {
        int refTotalCount = reference.getTotalCount();
        int decrTotalCount = decrypted.getTotalCount();

        double totalFreqDifference = 0.0;

        if (refTotalCount == 0 || decrTotalCount == 0) {
            throw new ApplicationException("Total count must not be zero");
        }
        for (String ch : reference.wordCount.keySet()) {
            double decrFreq = (double) decrypted.wordCount.
                    getOrDefault(ch, 0) / decrTotalCount;

            double refFreq = (double) reference.wordCount.
                    get(ch) / refTotalCount;

            totalFreqDifference += Math.abs(decrFreq - refFreq);
        }

        return totalFreqDifference;
    }

    private int getTotalCount() {
        if (totalCount == 0) {
            for (int count : wordCount.values()) {
                totalCount += count;
            }
        }
        return totalCount;
    }
}
