package org.example.fibonacci;

public class FibonacciIterative implements FibonacciStrategy {
    @Override
    public long solveFibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        long prev1 = 0, prev2 = 1;

        for (int i = 2; i <= n; i++) {
            long current = prev1 + prev2;
            prev1 = prev2;
            prev2 = current;
        }

        return prev2;
    }
}
