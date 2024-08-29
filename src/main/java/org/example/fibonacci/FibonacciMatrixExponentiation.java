package org.example.fibonacci;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.example.number.Constants.MATH_CONTEXT;

public class FibonacciMatrixExponentiation implements FibonacciStrategy<BigDecimal> {
    private static final Map<Long, BigDecimal> memo = new HashMap<>(); // space comp - O(1)

    @Override
    public BigDecimal solveFibonacci(long n) {
        if (n <= 1) {
            return BigDecimal.valueOf(n);
        }

        BigDecimal result = memo.get(n);  // time comp - O(1)

        if (result != null) {
            return result;
        }

        // space comp - O(1)
        BigDecimal[][] F = {
                {BigDecimal.ONE, BigDecimal.ONE},
                {BigDecimal.ONE, BigDecimal.ZERO}
        };
        power(F, n - 1);

        result = F[0][0];
        memo.put(n, result);

        return result;
    }

    private void power(BigDecimal[][] F, long n) {
        BigDecimal[][] M = {
                {BigDecimal.ONE, BigDecimal.ONE},
                {BigDecimal.ONE, BigDecimal.ZERO}
        };

        for (int i = 2; i <= n; i++) {
            multiply(F, M); // time comp - O(n)
        }
    }

    private void multiply(BigDecimal[][] F, BigDecimal[][] M) {
        BigDecimal x = F[0][0].multiply(M[0][0], MATH_CONTEXT).add(F[0][1].multiply(M[1][0], MATH_CONTEXT), MATH_CONTEXT);
        BigDecimal y = F[0][0].multiply(M[0][1], MATH_CONTEXT).add(F[0][1].multiply(M[1][1], MATH_CONTEXT), MATH_CONTEXT);
        BigDecimal z = F[1][0].multiply(M[0][0], MATH_CONTEXT).add(F[1][1].multiply(M[1][0], MATH_CONTEXT), MATH_CONTEXT);
        BigDecimal w = F[1][0].multiply(M[0][1], MATH_CONTEXT).add(F[1][1].multiply(M[1][1], MATH_CONTEXT), MATH_CONTEXT);

        F[0][0] = x;
        F[0][1] = y;
        F[1][0] = z;
        F[1][1] = w;
    }
}
