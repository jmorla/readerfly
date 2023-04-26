package com.hicx.readerfly.core.metric;

/**
 * A class that calculates the count of special characters in a given input string.
 *
 * Supported special characters include: '@', '#', and '$'.
 */
public class SpecialLetterCountMetric implements Metric<Integer> {


    /**
     * Calculates the count of special characters in the given input string.
     *
     * @param source the input string to calculate the count of special characters for
     * @return the count of special characters in the input string
     */
    @Override
    public Integer calculate(String source) {
        int count = 0;
        for (int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);
            if (c == '@' || c == '#' || c == '$') {
                count++;
            }
        }
        return count;
    }

    @Override
    public String getName() {
        return "Special Letter Count Metric";
    }
}
