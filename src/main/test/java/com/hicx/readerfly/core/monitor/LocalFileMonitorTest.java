package com.hicx.readerfly.core.monitor;

import com.hicx.readerfly.core.ReaderRegister;
import com.hicx.readerfly.core.metric.report.MetricReporter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LocalFileMonitorTest {

    private Path directory;
    private Path processedDirectory;
    private ReaderRegister readerRegister;
    private MetricReporter metricReporter;
    private LocalFileMonitor fileMonitor;

    @BeforeEach
    public void setUp() throws IOException {
        directory = Files.createTempDirectory("test");
        processedDirectory = directory.resolve("processed");
        readerRegister = Mockito.mock(ReaderRegister.class);
        metricReporter = Mockito.mock(MetricReporter.class);
        fileMonitor = new LocalFileMonitor(directory, readerRegister, metricReporter);
    }

    @Test
    public void testMonitorWithNoFiles() throws IOException {
        fileMonitor.monitor();
        Assertions.assertEquals(List.of(), Files.list(directory).toList());
    }


    @Test
    public void testMonitorWithInvalidDirectory() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new LocalFileMonitor(directory.resolve("invalid"), readerRegister, metricReporter));
    }
}
