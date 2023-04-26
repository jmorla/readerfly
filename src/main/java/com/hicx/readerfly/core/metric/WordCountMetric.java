package com.hicx.readerfly.core.metric;

/**
 * A class that calculates the number of words in a given input string.
 */
public class WordCountMetric implements Metric<Integer> {

    /**
     * Calculates the number of words in the given input string.
     *
     * @param source the input string to calculate the number of words for
     * @return the number of words in the input string
     */
    @Override
    public Integer calculate(String source) {
        String[] words = source.split("\\s+");
        return words.length;
    }

    @Override
    public String getName() {
        return "Word Count Metric";
    }
}
