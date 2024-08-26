package org.example.fibonacci;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class FibonacciDynamic implements FibonacciStrategy {
    private static Map<Integer, BigInteger> memo = new HashMap<>();

    @Override
    public BigInteger solveFibonacci(int n) {
        if (n <= 1) {
            return BigInteger.valueOf(n);
        }

        if (!memo.containsKey(n)) {
            BigInteger fib = solveFibonacci(n - 1).add(solveFibonacci(n - 2));
            memo.put(n, fib);
        }

        return memo.get(n);
    }
}
