package com.hicx.readerfly.core;

import com.hicx.readerfly.core.reader.PdfFileReader;
import com.hicx.readerfly.core.reader.PlainTextFileReader;

public class RegisterFactory {

    public static ReaderRegister createRegister () {
        ReaderRegister readerRegister = new ReaderRegister();

        readerRegister.register("text/plain", new PlainTextFileReader());
        readerRegister.register("application/pdf", new PdfFileReader());

        return readerRegister;
    }
}
