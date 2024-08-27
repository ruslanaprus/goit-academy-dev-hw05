package org.example.fibonacci;

import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.Map;

public class FibonacciMatrixExponentiation implements FibonacciStrategy<BigDecimal> {
    private static final Map<Integer, WeakReference<BigDecimal>> memo = new HashMap<>();
    private static final MathContext MATH_CONTEXT = new MathContext(100);

    @Override
    public BigDecimal solveFibonacci(int n) {
        if (n <= 1) {
            return BigDecimal.valueOf(n);
        }

        WeakReference<BigDecimal> weakReference = memo.get(n);
        BigDecimal result = (weakReference != null) ? weakReference.get() : null;

        if (result != null) {
            return result;
        }

        BigDecimal[][] F = {
                {BigDecimal.ONE, BigDecimal.ONE},
                {BigDecimal.ONE, BigDecimal.ZERO}
        };
        power(F, n - 1);

        result = F[0][0];
        memo.put(n, new WeakReference<>(result));

        return result;
    }

    @Override
    public Class<BigDecimal> getType() {
        return BigDecimal.class;
    }

    private void power(BigDecimal[][] F, int n) {
        BigDecimal[][] M = {
                {BigDecimal.ONE, BigDecimal.ONE},
                {BigDecimal.ONE, BigDecimal.ZERO}
        };

        for (int i = 2; i <= n; i++) {
            multiply(F, M);
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
