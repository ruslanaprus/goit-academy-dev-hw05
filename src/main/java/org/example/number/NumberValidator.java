package org.example.number;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.example.number.Constants.MAX_VALUE;
import static org.example.number.Constants.MIN_VALUE;

public class NumberValidator {
    private static final Logger defaultLogger = LoggerFactory.getLogger(NumberValidator.class);
    private final Logger logger;

    // Constructor to allow injecting a logger, with default fallback
    public NumberValidator() {
        this(defaultLogger);
    }

    // Constructor to inject a custom logger for testing purposes
    public NumberValidator(Logger logger) {
        this.logger = logger;
    }

    public boolean isValidNumber(int number) {
        if (number >= MIN_VALUE && number <= MAX_VALUE) {
            return true;
        } else {
            logger.warn("Number out of range. Number should be between {} and {}", MIN_VALUE, MAX_VALUE);
            return false;
        }
    }
}
