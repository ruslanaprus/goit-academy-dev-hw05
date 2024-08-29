package org.example.number;

import org.example.input.NumberSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.slf4j.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class NumberManagerTest {
    private NumberSource numberSource;
    private NumberManager numberManager;
    private Logger mockLogger;

    @BeforeEach
    void setUp() {
        numberSource = Mockito.mock(NumberSource.class);
        mockLogger = Mockito.mock(Logger.class);
        NumberManager.setLogger(mockLogger);
        numberManager = new NumberManager(numberSource);
    }

    @Test
    void testGetNumericValue() {
        when(numberSource.getNumber()).thenReturn(42);
        int result = numberManager.getNumericValue();
        assertEquals(42, result);
        verify(numberSource, times(1)).getNumber();
        verify(mockLogger, times(1)).debug("Retrieved number: {}", 42);
    }

    @Test
    void testLoggerInitialization() {
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockLogger, times(1)).debug(eq("NumberManager initialized with NumberSource: {}"), captor.capture());
        assertEquals("NumberSource", captor.getValue().split("\\$")[0]);
    }
}
