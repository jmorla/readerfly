package com.hicx.readerfly.core.reader;

import java.io.IOException;
import java.nio.file.Path;


/**
 * An interface for reading files from different sources.
 * Implementations of this interface can read files from local file system or remote HTTP servers.
 *
 * @see PlainTextFileReader
 */
public interface FileReader extends Reader<Path> {

    /**
     * Reads the contents of a file from the given path.
     *
     * @param path The path to the file to read.
     * @return The contents of the file as a string.
     */
    @Override
    String read(Path path) throws IOException;
}
