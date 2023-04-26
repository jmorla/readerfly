package com.hicx.readerfly;

import com.hicx.readerfly.core.RegisterFactory;
import com.hicx.readerfly.core.metric.DotCountMetric;
import com.hicx.readerfly.core.metric.MostFrequentWordMetric;
import com.hicx.readerfly.core.metric.SpecialLetterCountMetric;
import com.hicx.readerfly.core.metric.WordCountMetric;
import com.hicx.readerfly.core.metric.report.ConsoleMetricReporter;
import com.hicx.readerfly.core.monitor.LocalFileMonitor;

import java.nio.file.Path;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Application {

    public static void main(String[] args) {

        if(args.length < 1 || Objects.isNull(args[0]) || args[0].isBlank()) {
            System.err.println("path not provided");
            return;
        }

        var monitor = new LocalFileMonitor(
                Path.of(args[0]),
                RegisterFactory.createRegister(),
                ConsoleMetricReporter.withMetrics(
                        new DotCountMetric(),
                        new MostFrequentWordMetric(),
                        new SpecialLetterCountMetric(),
                        new WordCountMetric()
                ));

        var service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(monitor::monitor, 3, 3, TimeUnit.SECONDS);
    }
}
