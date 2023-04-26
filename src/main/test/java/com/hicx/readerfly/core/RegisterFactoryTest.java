package com.hicx.readerfly.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RegisterFactoryTest {

    @Test
    public void testCreateRegister() {
        ReaderRegister readerRegister = RegisterFactory.createRegister();
        Assertions.assertNotNull(readerRegister);
        for(var type: readerRegister.getAvailableTypes()) {
            Assertions.assertNotNull(type);
        }
    }
}
