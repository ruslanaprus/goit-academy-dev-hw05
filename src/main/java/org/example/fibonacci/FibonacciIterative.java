package org.example.fibonacci;

import java.math.BigInteger;

public class FibonacciIterative implements FibonacciStrategy {
    @Override
    public BigInteger solveFibonacci(int n) {
        if (n <= 1) {
            return BigInteger.valueOf(n);
        }

        BigInteger prev1 = BigInteger.ZERO;
        BigInteger prev2 = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            BigInteger current = prev1.add(prev2);
            prev1 = prev2;
            prev2 = current;
        }

        return prev2;
    }
}
