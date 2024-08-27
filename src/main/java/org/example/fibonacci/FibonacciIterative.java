package org.example.fibonacci;

import java.math.BigInteger;

public class FibonacciIterative implements FibonacciStrategy<BigInteger> {
    @Override
    public BigInteger solveFibonacci(int n) {
        if (n <= 1) {
            return BigInteger.valueOf(n);
        }

        // constant space complexity O(1)
        BigInteger prev1 = BigInteger.ZERO;
        BigInteger prev2 = BigInteger.ONE;

        // constant amount of space O(1) being used, regardless of the size of n
        for (int i = 2; i <= n; i++) { // time comp - O(n)
            BigInteger current = prev1.add(prev2);
            prev1 = prev2;
            prev2 = current;
        }

        return prev2;
    }

    @Override
    public Class<BigInteger> getType() {
        return BigInteger.class;
    }
}
