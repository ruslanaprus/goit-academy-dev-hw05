package org.example.input;

import org.example.fibonacci.FibonacciStrategy;
import org.example.fibonacci.FibonacciStrategyType;
import org.example.number.NumberValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class UserInputSource implements NumberSource, StrategySource, AutoCloseable {
    private static final Logger logger = LoggerFactory.getLogger(UserInputSource.class);
    private final NumberValidator numberValidator;
    private final Scanner scanner;

    public UserInputSource() {
        this.numberValidator = new NumberValidator();
        this.scanner = new Scanner(System.in);
    }

    @Override
    public int getNumber() {
        int number;
        do {
            logger.info("Please enter a number: ");
            number = getUserInput();
        } while (!numberValidator.isValidNumber(number));
        return number;
    }

    private int getUserInput() {
        while (!scanner.hasNextInt()) {
            logger.warn("Invalid input provided by the user.");
            logger.info("Invalid input. Please enter a valid positive number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    @Override
    public FibonacciStrategy getStrategy() {
        logger.info("Choose a Fibonacci strategy:");

        for (int i = 0; i < FibonacciStrategyType.values().length; i++) {
            logger.info("{}. {}", i + 1, FibonacciStrategyType.values()[i].getDescription());
        }

        int choice;
        do {
            logger.info("Enter the number corresponding to your choice: ");
            while (!scanner.hasNextInt()) {
                logger.warn("Invalid input. Please enter a number between 1 and {}.", FibonacciStrategyType.values().length);
                scanner.next();
            }
            choice = scanner.nextInt();
        } while (choice < 1 || choice > FibonacciStrategyType.values().length);

        return FibonacciStrategyType.values()[choice - 1].getStrategy();
    }

    @Override
    public void close() {
        if (scanner != null) {
            scanner.close();
        }
    }
}