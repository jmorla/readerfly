package com.hicx.readerfly.core.reader;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;

/**
 * A file reader that reads plain text files.
 */
public class PlainTextFileReader implements FileReader {

    /**
     * Reads the contents of a plain text file from the given path.
     *
     * @param path The path to the plain text file to read.
     * @return The contents of the file as a string.
     */
    @Override
    public String read(Path path) throws IOException {
        FileInputStream stream = new FileInputStream(path.toFile());
        return new String(stream.readAllBytes());
    }
}
