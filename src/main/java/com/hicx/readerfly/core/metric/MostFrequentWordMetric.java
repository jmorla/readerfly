package com.hicx.readerfly.core.metric;

import java.util.HashMap;
import java.util.Map;

/**
 * A class that calculates the most frequent word in a given input string.
 */
public class MostFrequentWordMetric implements Metric<String> {

    /**
     * Calculates the most frequent word in the given input string.
     *
     * @param source the input string to calculate the most frequent word for
     * @return the most frequent word in the input string, or null if there is no word in the input string
     */
    @Override
    public String calculate(String source) {
        String[] words = source.split("\\s+");
        Map<String, Integer> wordCounts = new HashMap<>();
        for (String word : words) {
            int count = wordCounts.getOrDefault(word, 0);
            wordCounts.put(word, count + 1);
        }
        String mostFrequentWord = null;
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostFrequentWord = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        return mostFrequentWord;
    }

    @Override
    public String getName() {
        return "Most Frequent Word Metric";
    }
}
