package org.example.fibonacci;

public interface FibonacciStrategy<T extends Number> {
    T solveFibonacci(int n);
}
