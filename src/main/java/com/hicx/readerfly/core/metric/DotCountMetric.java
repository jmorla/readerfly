package com.hicx.readerfly.core.metric;

/**
 * A class that calculates the number of dots in a given input string.
 */
public class DotCountMetric implements Metric<Integer>  {

    /**
     * Calculates the number of dots in the given input string.
     *
     * @param source the input string to calculate the number of dots for
     * @return the number of dots in the input string
     */
    @Override
    public Integer calculate(String source) {
        int count = 0;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) == '.') {
                count++;
            }
        }
        return count;
    }

    @Override
    public String getName() {
        return "Dot count Metric";
    }

}
