package org.example.fibonacci;

import java.math.BigDecimal;
import java.math.BigInteger;

public class FibonacciRecursive implements FibonacciStrategy {
    @Override
    public BigDecimal solveFibonacci(int n) {
        if (n <= 1) {
            return BigDecimal.valueOf(n);
        }

        return solveFibonacci(n - 1).add(solveFibonacci(n - 2));
    }
}
