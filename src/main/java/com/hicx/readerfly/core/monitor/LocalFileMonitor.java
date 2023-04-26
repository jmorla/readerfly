package com.hicx.readerfly.core.monitor;

import com.hicx.readerfly.core.ReaderRegister;
import com.hicx.readerfly.core.metric.report.MetricReporter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LocalFileMonitor {

    private Logger log = Logger.getLogger(LocalFileMonitor.class.getName());

    private ReaderRegister register;

    private Path directory;

    private Path processedDirectory;

    private MetricReporter reporter;

    public LocalFileMonitor(
            Path directory,
            ReaderRegister register,
            MetricReporter reporter
    ) {
        if (!Files.isDirectory(directory)) {
            throw new IllegalArgumentException(directory + " is not a directory");
        }
        this.directory = directory;
        this.processedDirectory = directory.resolve("processed");
        this.register = register;
        this.reporter = reporter;
    }

    public void monitor() {
        try {
            Files.list(directory).forEach(this::processFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void processFile(Path path) {
        try {
            for (var availableReader : register.getAvailableTypes()) {
                var fileType = Files.probeContentType(path);
                if (availableReader.equals(fileType)) {
                    var reader = register.getReader(availableReader);
                    reporter.report(reader.read(path));
                    moveFile(path);
                }
            }
        } catch (IOException ex) {
            log.log(Level.SEVERE, "error reading file: {0}", ex.getMessage());
        }
    }

    private void moveFile(Path path) {
        try {
            if (!Files.exists(this.processedDirectory) || !Files.isDirectory(this.processedDirectory)) {
                Files.createDirectory(this.processedDirectory);
            }
            Files.move(path, this.processedDirectory.resolve(path.getFileName()));
        } catch (IOException exception) {
            throw new RuntimeException("Unable to create or access to processed directory");
        }
    }
}
