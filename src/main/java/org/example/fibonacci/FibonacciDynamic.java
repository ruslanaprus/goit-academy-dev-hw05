package org.example.fibonacci;

import java.math.BigInteger;
import java.util.Map;
import java.util.WeakHashMap;

public class FibonacciDynamic implements FibonacciStrategy {

    private static Map<Integer, BigInteger> memo = new WeakHashMap<>();

    @Override
    public BigInteger solveFibonacci(int n) {
        if (n <= 1) {
            return BigInteger.valueOf(n);
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        BigInteger prev = BigInteger.ZERO;
        BigInteger curr = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            BigInteger next = prev.add(curr);
            prev = curr;
            curr = next;
            memo.put(i, curr);
        }

        return curr;
    }
}
