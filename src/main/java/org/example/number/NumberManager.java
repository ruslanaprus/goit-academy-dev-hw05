package org.example.number;

import org.example.input.NumberSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NumberManager {
    private static final Logger logger = LoggerFactory.getLogger(NumberManager.class);
    private final NumberSource numberSource;

    public NumberManager(NumberSource numberSource) {
        this.numberSource = numberSource;
        logger.debug("NumberManager initialized with NumberSource: {}", numberSource.getClass().getSimpleName());
    }

    public int getNumericValue() {
        return numberSource.getNumber();
    }
}