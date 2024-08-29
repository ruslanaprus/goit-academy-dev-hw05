package org.example.number;

import org.example.input.NumberSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NumberManager {
    private static Logger logger = LoggerFactory.getLogger(NumberManager.class);
    private final NumberSource numberSource;

    public NumberManager(NumberSource numberSource) {
        this.numberSource = numberSource;
        logger.debug("NumberManager initialized with NumberSource: {}", numberSource.getClass().getSimpleName());
    }

    public static void setLogger(Logger logger) {
        NumberManager.logger = logger;
    }

    public int getNumericValue() {
        try {
            int number = numberSource.getNumber();
            logger.debug("Retrieved number: {}", number);
            return number;
        } catch (Exception e) {
            logger.error("Error retrieving number", e);
            throw e;
        }
    }
}
