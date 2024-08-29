package org.example.number;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.slf4j.Logger;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.example.number.Constants.MAX_VALUE;
import static org.example.number.Constants.MIN_VALUE;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class NumberValidatorTest {

    private NumberValidator numberValidator;
    private Logger logger;

    @BeforeEach
    void setUp() {
        logger = mock(Logger.class);  // Mocking the logger
        numberValidator = new NumberValidator(logger);  // Injecting mock logger
    }

    @Test
    @DisplayName("Number within valid range")
    void testValidNumberWithinRange() {
        assertTrue(numberValidator.isValidNumber((MAX_VALUE + MIN_VALUE) / 2), "Number within range should be valid");
    }

    @Test
    @DisplayName("Number at minimum value")
    void testValidNumberAtMinValue() {
        assertTrue(numberValidator.isValidNumber(MIN_VALUE), "Number at MIN_VALUE should be valid");
    }

    @Test
    @DisplayName("Number at maximum value")
    void testValidNumberAtMaxValue() {
        assertTrue(numberValidator.isValidNumber(MAX_VALUE), "Number at MAX_VALUE should be valid");
    }

    @Test
    @DisplayName("Number just below minimum value")
    void testInvalidNumberBelowMinValue() {
        assertFalse(numberValidator.isValidNumber(MIN_VALUE - 1), "Number below MIN_VALUE should be invalid");
        verify(logger).warn("Number out of range. Number should be between {} and {}", MIN_VALUE, MAX_VALUE);
    }

    @Test
    @DisplayName("Number just above maximum value")
    void testInvalidNumberAboveMaxValue() {
        assertFalse(numberValidator.isValidNumber(MAX_VALUE + 1), "Number above MAX_VALUE should be invalid");
        verify(logger).warn("Number out of range. Number should be between {} and {}", MIN_VALUE, MAX_VALUE);
    }

    @Test
    @DisplayName("Number far below minimum value")
    void testInvalidNumberFarBelowMinValue() {
        assertFalse(numberValidator.isValidNumber(MIN_VALUE - 1000), "Number far below MIN_VALUE should be invalid");
        verify(logger).warn("Number out of range. Number should be between {} and {}", MIN_VALUE, MAX_VALUE);
    }

    @Test
    @DisplayName("Number far above maximum value")
    void testInvalidNumberFarAboveMaxValue() {
        assertFalse(numberValidator.isValidNumber(MAX_VALUE + 1000), "Number far above MAX_VALUE should be invalid");
        verify(logger).warn("Number out of range. Number should be between {} and {}", MIN_VALUE, MAX_VALUE);
    }

    @Test
    @DisplayName("Number is Integer.MIN_VALUE")
    void testInvalidNumberAtIntegerMinValue() {
        assertFalse(numberValidator.isValidNumber(Integer.MIN_VALUE), "Integer.MIN_VALUE should be invalid");
        verify(logger).warn("Number out of range. Number should be between {} and {}", MIN_VALUE, MAX_VALUE);
    }

    @Test
    @DisplayName("Test with default logger and invalid input")
    void testLoggerWithInvalidInput() {
        // Create a mock logger and inject it into the NumberValidator
        Logger mockLogger = mock(Logger.class);
        NumberValidator defaultValidator = new NumberValidator(mockLogger);  // Using default constructor with mock

        // Perform an invalid number check
        assertFalse(defaultValidator.isValidNumber(MAX_VALUE + 1), "Number above MAX_VALUE should be invalid");

        // Capture the log message
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockLogger).warn(captor.capture(), eq(MIN_VALUE), eq(MAX_VALUE));

        // Assert that the captured log message matches the expected message
        String expectedLogMessage = "Number out of range. Number should be between {} and {}";
        assertEquals(expectedLogMessage, captor.getValue(), "Expected log message not found");
    }

    @Test
    @DisplayName("Test with default logger and invalid input")
    void testDefaultLoggerWithInvalidInput() {
        // Capture the logging output from the default logger
//        Logger defaultLogger = LoggerFactory.getLogger(NumberValidator.class);
        NumberValidator defaultLoggerValidator = new NumberValidator();  // Use default logger

        // Redirect the output to capture it
        ByteArrayOutputStream logOutput = new ByteArrayOutputStream();
        PrintStream originalSystemOut = System.out;
        System.setOut(new PrintStream(logOutput));

        // Perform an invalid number check
        assertFalse(defaultLoggerValidator.isValidNumber(MAX_VALUE + 1), "Number above MAX_VALUE should be invalid");

        // Restore the original System.out
        System.setOut(originalSystemOut);

        // Verify that the log message is present in the captured output
        String expectedLogMessage = String.format("Number out of range. Number should be between %d and %d", MIN_VALUE, MAX_VALUE);
        String logOutputStr = logOutput.toString();
        assertTrue(logOutputStr.contains(expectedLogMessage), "Expected log message not found");
    }

}
