package org.example.fibonacci;

import java.util.HashMap;
import java.util.Map;

public class FibonacciDynamic implements FibonacciStrategy {
    private static Map<Integer, Long> memo = new HashMap<>();

    @Override
    public long solveFibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        if (!memo.containsKey(n)) {
            long fib = solveFibonacci(n - 1) + solveFibonacci(n - 2);
            memo.put(n, fib);
        }

        return memo.get(n);
    }
}
