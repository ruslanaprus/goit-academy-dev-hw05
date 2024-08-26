package org.example;

import org.example.fibonacci.FibonacciStrategy;
import org.example.input.NumberSource;
import org.example.input.StrategySource;
import org.example.input.UserInputSource;
import org.example.number.NumberManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.BigInteger;

public class AppLauncher {
    private static final Logger logger = LoggerFactory.getLogger(AppLauncher.class);

    public static void main(String[] args) {
        try (UserInputSource inputSource = new UserInputSource()) {
            NumberSource numberSource = inputSource;
            StrategySource strategySource = inputSource;

            NumberManager numberManager = new NumberManager(numberSource);
            int number = numberManager.getNumericValue();

            FibonacciStrategy<?> strategy = strategySource.getStrategy();

            long startTime = System.nanoTime();
            launch(number, strategy);
            long stopTime = System.nanoTime();
            logger.info("It took {} nanoseconds to calculate it", (stopTime - startTime));
        } catch (Exception e) {
            logger.error("An error occurred: {}", e.getMessage(), e);
        }
    }

    public static <T extends Number> void launch(int number, FibonacciStrategy<T> strategy) {
        try {
            T result = strategy.solveFibonacci(number);
            logger.info("Using {}: The value in Fibonacci sequence at the {}-th position is {}",
                    strategy.getClass().getSimpleName(), number, result);
        } catch (IllegalStateException | IllegalArgumentException e) {
            logger.error("Error: {}", e.getMessage(), e);
        }
    }
}