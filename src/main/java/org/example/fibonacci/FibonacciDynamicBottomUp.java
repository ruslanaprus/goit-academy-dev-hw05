package org.example.fibonacci;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.Map;

public class FibonacciDynamicBottomUp implements FibonacciStrategy<BigDecimal> {
    // Causes OutOfMemoryError at more than ≈ 10_000_000
    private static final Map<Integer, BigDecimal> memo = new HashMap<>();
    private static final MathContext MATH_CONTEXT = new MathContext(100);

    public BigDecimal solveFibonacci(int n) {
        if (n <= 1) {
            return BigDecimal.valueOf(n);
        }

        memo.put(0, BigDecimal.ZERO);
        memo.put(1, BigDecimal.ONE);

        for (int i = 2; i <= n; i++) {
            BigDecimal fibNMinus1 = memo.get(i - 1);
            BigDecimal fibNMinus2 = memo.get(i - 2);
            memo.put(i, fibNMinus1.add(fibNMinus2, MATH_CONTEXT));
        }

        return memo.get(n);
    }

    public Class<BigDecimal> getType() {
        return BigDecimal.class;
    }
}