package org.example.fibonacci;

import java.math.BigInteger;

public class FibonacciRecursiveMatrixExponentiation implements FibonacciStrategy<BigInteger> {
    @Override
    public BigInteger solveFibonacci(int n) {
        if (n <= 1) {
            return BigInteger.valueOf(n);
        }

        // space comp - O(1)
        BigInteger[][] F = {
                {BigInteger.ONE, BigInteger.ONE},
                {BigInteger.ONE, BigInteger.ZERO}
        };

        matrixPower(F, n - 1);

        return F[0][0];
    }

    @Override
    public Class<BigInteger> getType() {
        return BigInteger.class;
    }

    // reduces the problem size by half in each recursive call, time comp - O(log n)
    private void matrixPower(BigInteger[][] F, int n) {
        if (n == 1 || n == 0) return;

        // space comp - O(1)
        BigInteger[][] M = {
                {BigInteger.ONE, BigInteger.ONE},
                {BigInteger.ONE, BigInteger.ZERO}
        };

        matrixPower(F, n / 2); // space complexity due to the call stack - O(log n)
        multiply(F, F);

        if (n % 2 != 0) {
            multiply(F, M);
        }
    }

    private void multiply(BigInteger[][] F, BigInteger[][] M) { // each multiplication has time comp - O(1)
        BigInteger x = F[0][0].multiply(M[0][0]).add(F[0][1].multiply(M[1][0]));
        BigInteger y = F[0][0].multiply(M[0][1]).add(F[0][1].multiply(M[1][1]));
        BigInteger z = F[1][0].multiply(M[0][0]).add(F[1][1].multiply(M[1][0]));
        BigInteger w = F[1][0].multiply(M[0][1]).add(F[1][1].multiply(M[1][1]));

        F[0][0] = x;
        F[0][1] = y;
        F[1][0] = z;
        F[1][1] = w;
    }
}
