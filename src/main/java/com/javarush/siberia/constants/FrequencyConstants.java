package com.javarush.siberia.constants;

import java.util.Map;
import java.util.TreeMap;

public class FrequencyConstants {

    public static final Map<Character, Double> ENGLISH_FREQUENCY = createEnglishFrequency();
    public static final Map<Character, Double> RUSSIAN_FREQUENCY = createRussianFrequency();

    private static Map<Character, Double> createEnglishFrequency() {
        Map<Character, Double> frequencyMap = new TreeMap<>();
        frequencyMap.put('e', 12.70);
        frequencyMap.put('t', 9.06);
        frequencyMap.put('a', 8.17);
        frequencyMap.put('o', 7.51);
        frequencyMap.put('i', 6.97);
        frequencyMap.put('n', 6.75);
        frequencyMap.put('s', 6.33);
        frequencyMap.put('h', 6.09);
        frequencyMap.put('r', 5.99);
        frequencyMap.put('d', 4.25);
        frequencyMap.put('l', 4.03);
        frequencyMap.put('u', 2.76);
        frequencyMap.put('c', 2.23);
        frequencyMap.put('m', 2.02);
        frequencyMap.put('f', 1.82);
        frequencyMap.put('y', 1.97);
        frequencyMap.put('w', 1.92);
        frequencyMap.put('g', 1.73);
        frequencyMap.put('p', 1.66);
        frequencyMap.put('b', 1.49);
        frequencyMap.put('v', 1.11);
        frequencyMap.put('k', 0.77);
        frequencyMap.put('x', 0.15);
        frequencyMap.put('q', 0.10);
        frequencyMap.put('j', 0.10);
        frequencyMap.put('z', 0.07);
        frequencyMap.put(' ', 16.00);
        return frequencyMap;
    }

    private static Map<Character, Double> createRussianFrequency() {
        Map<Character, Double> frequencyMap = new TreeMap<>();
        frequencyMap.put('о', 10.97);
        frequencyMap.put('е', 8.45);
        frequencyMap.put('а', 8.01);
        frequencyMap.put('и', 7.34);
        frequencyMap.put('н', 6.71);
        frequencyMap.put('т', 6.60);
        frequencyMap.put('с', 5.43);
        frequencyMap.put('р', 4.81);
        frequencyMap.put('л', 4.46);
        frequencyMap.put('в', 4.43);
        frequencyMap.put('д', 3.96);
        frequencyMap.put('м', 3.79);
        frequencyMap.put('к', 3.52);
        frequencyMap.put('у', 3.47);
        frequencyMap.put('ы', 3.31);
        frequencyMap.put('з', 2.86);
        frequencyMap.put('ь', 2.63);
        frequencyMap.put('я', 2.54);
        frequencyMap.put('ч', 2.51);
        frequencyMap.put('г', 2.46);
        frequencyMap.put('б', 2.29);
        frequencyMap.put('ш', 1.96);
        frequencyMap.put('э', 1.87);
        frequencyMap.put('ю', 1.59);
        frequencyMap.put('ж', 1.25);
        frequencyMap.put('х', 1.14);
        frequencyMap.put('ц', 1.09);
        frequencyMap.put('щ', 0.89);
        frequencyMap.put('ф', 0.60);
        frequencyMap.put('ъ', 0.25);
        frequencyMap.put(' ', 17.00);
        return frequencyMap;
    }
}