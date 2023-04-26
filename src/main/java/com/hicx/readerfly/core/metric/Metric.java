package com.hicx.readerfly.core.metric;

/**
 * An interface for a metric that calculates a specific value based on an input of type T.
 *
 * @param <T> the type of input that this metric takes
 */
public interface Metric<T> {

    /**
     * Calculates the metric value for the given input.
     *
     * @param source the input value to calculate the metric for
     * @return the calculated metric value
     */
    T calculate (String source);

    String getName();
}
