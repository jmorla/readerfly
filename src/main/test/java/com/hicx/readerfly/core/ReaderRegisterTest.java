package com.hicx.readerfly.core;

import com.hicx.readerfly.core.reader.FileReader;
import com.hicx.readerfly.core.reader.PdfFileReader;
import com.hicx.readerfly.core.reader.PlainTextFileReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ReaderRegisterTest {
    private ReaderRegister readerRegister;

    @BeforeEach
    public void setUp() {
        readerRegister = new ReaderRegister();
    }

    @Test
    public void testRegisterAndGetReader() {
        FileReader reader = new PlainTextFileReader();
        readerRegister.register("text/plain", reader);
        Assertions.assertEquals(reader, readerRegister.getReader("text/plain"));
    }

    @Test
    public void testGetReaderWithInvalidName() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> readerRegister.getReader("invalid"));
    }

    @Test
    public void testGetAvailableTypes() {
        readerRegister.register("text/plain", new PlainTextFileReader());
        readerRegister.register("application/pdf", new PdfFileReader());
        List<String> availableTypes = readerRegister.getAvailableTypes();
        Assertions.assertEquals(2, availableTypes.size());
        Assertions.assertTrue(availableTypes.contains("text/plain"));
        Assertions.assertTrue(availableTypes.contains("application/pdf"));
    }
}
