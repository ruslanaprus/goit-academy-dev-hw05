package org.example.fibonacci;

import java.util.HashMap;
import java.util.Map;

public class FibonacciDynamic {
    private static Map<Integer, Long> memo = new HashMap<>();

    public static long solveFibonacci(int n) {
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
