package org.example.fibonacci;

import java.math.BigDecimal;

import static org.example.number.Constants.MATH_CONTEXT;

public class FibonacciIterative implements FibonacciStrategy<BigDecimal> {
    @Override
    public BigDecimal solveFibonacci(long n) {
        if (n <= 1) {
            return BigDecimal.valueOf(n);
        }

        // constant space complexity O(1)
        BigDecimal prev1 = BigDecimal.ZERO;
        BigDecimal prev2 = BigDecimal.ONE;

        // constant amount of space O(1) being used, regardless of the size of n
        for (int i = 2; i <= n; i++) { // time comp - O(n)
            BigDecimal current = prev1.add(prev2, MATH_CONTEXT);
            prev1 = prev2;
            prev2 = current;
        }

        return prev2;
    }
}
