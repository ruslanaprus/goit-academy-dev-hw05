package org.example.fibonacci;

import java.lang.ref.WeakReference;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class FibonacciDynamic implements FibonacciStrategy {
    private static final Map<Integer, WeakReference<BigInteger>> memo = new HashMap<>();

    @Override
    public BigInteger solveFibonacci(int n) {
        if (n <= 1) {
            return BigInteger.valueOf(n);
        }

        WeakReference<BigInteger> weakReference = memo.get(n);
        BigInteger result = (weakReference != null) ? weakReference.get() : null;

        if (result != null) {
            return result;
        }

        BigInteger prev = BigInteger.ZERO;
        BigInteger current = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            BigInteger next = prev.add(current);
            prev = current;
            current = next;
        }

        memo.put(n, new WeakReference<>(current));

        return current;
    }
}
