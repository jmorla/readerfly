package com.hicx.readerfly.core;

import com.hicx.readerfly.core.reader.FileReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReaderRegister {
    private Map<String, FileReader> readers = new HashMap<>();

    public void register(String name, FileReader reader) {
        readers.put(name, reader);
    }

    public FileReader getReader(String name) {
        if(!readers.containsKey(name)) {
            throw new IllegalArgumentException("Invalid reader name");
        }
        return readers.get(name);
    }

    public List<String> getAvailableTypes () {
        return readers.keySet().stream().toList();
    }
}
