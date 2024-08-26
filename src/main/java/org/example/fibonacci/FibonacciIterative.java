package org.example.fibonacci;

import java.math.BigDecimal;
import java.math.BigInteger;

public class FibonacciIterative implements FibonacciStrategy {
    @Override
    public BigDecimal solveFibonacci(int n) {
        if (n <= 1) {
            return BigDecimal.valueOf(n);
        }

        BigDecimal prev1 = BigDecimal.ZERO;
        BigDecimal prev2 = BigDecimal.ONE;

        for (int i = 2; i <= n; i++) {
            BigDecimal current = prev1.add(prev2);
            prev1 = prev2;
            prev2 = current;
        }

        return prev2;
    }
}
