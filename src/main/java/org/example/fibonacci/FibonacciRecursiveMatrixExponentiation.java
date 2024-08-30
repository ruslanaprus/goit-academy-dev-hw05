package org.example.fibonacci;

import java.math.BigDecimal;

import static org.example.number.Constants.MATH_CONTEXT;

public class FibonacciRecursiveMatrixExponentiation implements FibonacciStrategy<BigDecimal> {
    @Override
    public BigDecimal solveFibonacci(int n) {
        if (n <= 1) {
            return BigDecimal.valueOf(n);
        }

        // space comp - O(1)
        BigDecimal[][] F = {
                {BigDecimal.ONE, BigDecimal.ONE},
                {BigDecimal.ONE, BigDecimal.ZERO}
        };

        matrixPower(F, n - 1);

        return F[0][0];
    }

    // reduces the problem size by half in each recursive call, time comp - O(log n)
    private void matrixPower(BigDecimal[][] F, int n) {
        if (n == 1 || n == 0) return;

        // space comp - O(1)
        BigDecimal[][] M = {
                {BigDecimal.ONE, BigDecimal.ONE},
                {BigDecimal.ONE, BigDecimal.ZERO}
        };

        matrixPower(F, n >> 1); // space complexity due to the call stack - O(log n)
        multiply(F, F);

        if (n % 2 != 0) {
            multiply(F, M);
        }
    }

    private void multiply(BigDecimal[][] F, BigDecimal[][] M) { // each multiplication has time comp - O(1)
        BigDecimal x = F[0][0].multiply(M[0][0], MATH_CONTEXT)
                .add(F[0][1].multiply(M[1][0], MATH_CONTEXT), MATH_CONTEXT);
        BigDecimal y = F[0][0].multiply(M[0][1], MATH_CONTEXT)
                .add(F[0][1].multiply(M[1][1], MATH_CONTEXT), MATH_CONTEXT);
        BigDecimal z = F[1][0].multiply(M[0][0], MATH_CONTEXT)
                .add(F[1][1].multiply(M[1][0], MATH_CONTEXT), MATH_CONTEXT);
        BigDecimal w = F[1][0].multiply(M[0][1], MATH_CONTEXT)
                .add(F[1][1].multiply(M[1][1], MATH_CONTEXT), MATH_CONTEXT);

        F[0][0] = x;
        F[0][1] = y;
        F[1][0] = z;
        F[1][1] = w;
    }
}
