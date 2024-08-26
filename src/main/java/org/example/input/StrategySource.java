package org.example.input;

import org.example.fibonacci.FibonacciStrategy;

public interface StrategySource {
    <T extends Number> FibonacciStrategy<T> getStrategy();
}
