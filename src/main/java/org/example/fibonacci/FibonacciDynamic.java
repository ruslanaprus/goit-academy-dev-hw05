package org.example.fibonacci;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.example.number.Constants.MATH_CONTEXT;


public class FibonacciDynamic implements FibonacciStrategy<BigDecimal> {
    private static final Map<Integer, BigDecimal> memo = new LinkedHashMap<Integer, BigDecimal>(8, 0.75f, true) {
        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, BigDecimal> eldest) {
            return size() > 5;
        }
    };

    @Override
    public BigDecimal solveFibonacci(int n) {
        if (n <= 1) {
            return BigDecimal.valueOf(n);
        }

        memo.put(0, BigDecimal.ZERO);
        memo.put(1, BigDecimal.ONE);

        for (int i = 2; i <= n; i++) {
            BigDecimal previousFib = memo.get(i - 1);
            BigDecimal twoStepsBackFib = memo.get(i - 2);
            memo.put(i, previousFib.add(twoStepsBackFib, MATH_CONTEXT));
        }

        return memo.get(n);
    }
}