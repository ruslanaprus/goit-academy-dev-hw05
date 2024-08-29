package org.example.fibonacci;

import java.util.concurrent.TimeUnit;

public interface FibonacciStrategy<T extends Number> {
    T solveFibonacci(int n);
//    T solveFibonacci(int n, TimeUnit timeUnit); // Overloaded method

    default T solveFibonacci(int n, TimeUnit timeUnit) {
        return solveFibonacci(n); // Default implementation calls the single-parameter method
    }

    Class<T> getType();
}
