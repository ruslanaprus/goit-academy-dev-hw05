package org.example.fibonacci;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.example.number.Constants.MATH_CONTEXT;


public class FibonacciDynamic implements FibonacciStrategy<BigDecimal> {
    // due to the limited size of the map, space used by the map is constant, so space comp - O(1)
    private static final Map<Integer, BigDecimal> memo = new LinkedHashMap<Integer, BigDecimal>(8, 0.75f, true) {
        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, BigDecimal> eldest) {
            return size() > 5;
        }
    };

    @Override
    public BigDecimal solveFibonacci(int n) {
        if (n <= 1) {
            return BigDecimal.valueOf(n); // time comp - O(1)
        }

        memo.put(0, BigDecimal.ZERO); // time comp - O(1)
        memo.put(1, BigDecimal.ONE); // time comp - O(1)

        for (int i = 2; i <= n; i++) { // time comp - O(n)
            BigDecimal previousFib = memo.get(i - 1); // space comp - O(1)
            BigDecimal twoStepsBackFib = memo.get(i - 2); // space comp - O(1)
            memo.put(i, previousFib.add(twoStepsBackFib, MATH_CONTEXT)); // time comp - O(1)
        }

        return memo.get(n); // time comp - O(1)
    }
}