package org.example;

import org.example.fibonacci.FibonacciStrategy;
import org.example.input.NumberSource;
import org.example.input.StrategySource;
import org.example.input.UserInputSource;
import org.example.number.NumberManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppLauncher {
    private static final Logger logger = LoggerFactory.getLogger(AppLauncher.class);

    public static void main(String[] args) {
        NumberSource numberSource = new UserInputSource();
        StrategySource strategySource = new UserInputSource();

        NumberManager numberManager = new NumberManager(numberSource);
        int number = numberManager.getNumericValue();

        FibonacciStrategy strategy = strategySource.getStrategy();

        launch(number, strategy);
    }

    public static void launch(int number, FibonacciStrategy strategy) {
        try {
            long result = strategy.solveFibonacci(number);
            logger.info("Using {}: The value in Fibonacci sequence at the {}-th position is {}",
                    strategy.getClass().getSimpleName(), number, result);
        } catch (IllegalStateException | IllegalArgumentException e) {
            logger.error("Error: {}", e.getMessage(), e);
        }
    }
}