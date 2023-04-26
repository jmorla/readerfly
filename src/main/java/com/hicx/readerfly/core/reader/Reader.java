package com.hicx.readerfly.core.reader;

import java.io.IOException;

/**
 * An interface for reading data from a source.
 *
 * @param <T> The type of source to read from.
 */
public interface Reader<T> {

    /**
     * Reads the contents of a source and returns them as a string.
     *
     * @param source The source to read from.
     * @return The contents of the source as a string.
     */
    String read(T source) throws IOException;
}
