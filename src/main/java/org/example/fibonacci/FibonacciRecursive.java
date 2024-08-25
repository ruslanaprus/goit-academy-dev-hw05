package org.example.fibonacci;

public class FibonacciRecursive implements FibonacciStrategy {
    @Override
    public long solveFibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        return solveFibonacci(n - 1) + solveFibonacci(n - 2);
    }
}
