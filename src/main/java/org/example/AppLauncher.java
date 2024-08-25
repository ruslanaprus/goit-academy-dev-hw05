package org.example;

import org.example.fibonacci.*;
import org.example.number.NumberGetter;
import org.example.number.NumberManager;
import org.example.number.UserInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppLauncher {
    private static final Logger logger = LoggerFactory.getLogger(AppLauncher.class);

    public static void main(String[] args) {
        AppLauncher.launch(new UserInput());
    }

    public static void launch(NumberGetter numberGetter) {
        try {
            NumberManager numberManager = new NumberManager(numberGetter);
            int number = numberManager.getNumericValue();
            logger.info("The value in Fibonacci sequence at the {}-th position is {}", number, FibonacciRecursive.solveFibonacci(number));
            logger.info("The value in Fibonacci sequence at the {}-th position is {}", number, FibonacciIterative.solveFibonacci(number));
            logger.info("The value in Fibonacci sequence at the {}-th position is {}", number, FibonacciDynamic.solveFibonacci(number));
        } catch (IllegalStateException | IllegalArgumentException e) {
            logger.error("Error: {}", e.getMessage(), e);
        }
    }
}