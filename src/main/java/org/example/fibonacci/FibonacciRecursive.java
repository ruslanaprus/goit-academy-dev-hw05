package org.example.fibonacci;

public class FibonacciRecursive {
    public static long solveFibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        return solveFibonacci(n - 1) + solveFibonacci(n - 2);
    }
}
