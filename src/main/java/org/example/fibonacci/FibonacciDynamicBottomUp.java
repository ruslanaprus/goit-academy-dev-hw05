package org.example.fibonacci;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.example.number.Constants.MATH_CONTEXT;


public class FibonacciDynamicBottomUp implements FibonacciStrategy<BigDecimal> {
    private static final Map<Integer, BigDecimal> memo = new LinkedHashMap<Integer, BigDecimal>(16, 0.75f, true) {
        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, BigDecimal> eldest) {
            return size() > 10000000;
        }
    };

    @Override
    public BigDecimal solveFibonacci(long n) {
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
}