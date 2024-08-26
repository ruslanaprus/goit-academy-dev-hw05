package org.example.fibonacci;

import java.math.BigInteger;

public class FibonacciRecursive implements FibonacciStrategy<BigInteger> {
    @Override
    public BigInteger solveFibonacci(int n) {
        if (n <= 1) {
            return BigInteger.valueOf(n);
        }

        return solveFibonacci(n - 1).add(solveFibonacci(n - 2));
    }

    @Override
    public Class<BigInteger> getType() {
        return BigInteger.class;
    }
}
