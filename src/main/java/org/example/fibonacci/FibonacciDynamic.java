package org.example.fibonacci;

import java.lang.ref.WeakReference;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class FibonacciDynamic implements FibonacciStrategy<BigInteger> {
    private static final Map<Integer, WeakReference<BigInteger>> memo = new HashMap<>(); // space comp - O(n), due to the use of WeakReference, the actual space might be less because some entries could be garbage collected

    @Override
    public BigInteger solveFibonacci(int n) {
        if (n <= 1) {
            return BigInteger.valueOf(n);
        }

        WeakReference<BigInteger> weakReference = memo.get(n); // time comp - O(1)
        BigInteger result = (weakReference != null) ? weakReference.get() : null; // time comp - O(1)

        if (result != null) {
            return result;
        }

        BigInteger prev = BigInteger.ZERO; // space comp - O(1)
        BigInteger current = BigInteger.ONE; // space comp - O(1)

        for (int i = 2; i <= n; i++) { // time comp - O(n) - time complexity is dominated by the loop (O(n))
            BigInteger next = prev.add(current); // space comp - O(1)
            prev = current;
            current = next;
        }

        memo.put(n, new WeakReference<>(current));

        return current;
    }

    @Override
    public Class<BigInteger> getType() {
        return BigInteger.class;
    }
}
