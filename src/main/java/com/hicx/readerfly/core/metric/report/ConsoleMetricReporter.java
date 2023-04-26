package com.hicx.readerfly.core.metric.report;

import com.hicx.readerfly.core.metric.Metric;

import java.util.List;

/**
 * A metric reporter that prints metric reports to the console.
 */
public class ConsoleMetricReporter implements MetricReporter {

    private List<Metric> metrics;

    /**
     * Constructs a new ConsoleMetricReporter with the given list of metrics.
     *
     * @param metrics the list of metrics to report.
     */
    private ConsoleMetricReporter(List<Metric> metrics) {
        this.metrics = metrics;
    }

    public static ConsoleMetricReporter withMetrics (Metric<?>... metrics) {
        return new ConsoleMetricReporter(List.of(metrics));
    }

    /**
     * Reports the metrics for the given source to the console.
     *
     * @param source the source for which to report metrics.
     */
    @Override
    public void report(String source) {
        metrics.stream().forEach(metric -> printReport(metric, source));
    }

    /**
     * Prints a metric report for the given metric and source to the console.
     *
     * @param metric the metric to report.
     * @param source the source for which to report the metric.
     */
    public void printReport(Metric<?> metric, String source) {
        System.out.println(metric.getName() + ": " + metric.calculate(source));
    }
}
