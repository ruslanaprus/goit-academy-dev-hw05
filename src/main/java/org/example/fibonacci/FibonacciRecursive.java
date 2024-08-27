package org.example.fibonacci;

import java.math.BigInteger;

public class FibonacciRecursive implements FibonacciStrategy<BigInteger> {
    @Override
    public BigInteger solveFibonacci(int n) {
        if (n <= 1) { // space comp - O(n), maximum depth of the recursion is n, the function continues to call itself with decrements of n until n reaches 1 or 0.
            return BigInteger.valueOf(n);
        }

        return solveFibonacci(n - 1).add(solveFibonacci(n - 2)); // time comp - O(2^n) due to double recursive call
    }

    @Override
    public Class<BigInteger> getType() {
        return BigInteger.class;
    }
}
