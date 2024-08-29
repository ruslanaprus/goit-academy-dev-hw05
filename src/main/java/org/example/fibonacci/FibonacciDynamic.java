package org.example.fibonacci;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class FibonacciDynamic implements FibonacciStrategy<BigInteger> {
    private static final Map<Integer, BigInteger> memo = new HashMap<>(); // space comp - O(1)

    @Override
    public BigInteger solveFibonacci(int n) {
        if (n <= 1) {
            return BigInteger.valueOf(n);
        }

        BigInteger result = memo.get(n); // time comp - O(1)

        if (result != null) {
            return result;
        }

        BigInteger prev = BigInteger.ZERO; // space comp - O(1)
        BigInteger current = BigInteger.ONE; // space comp - O(1)

        for (int i = 2; i <= n; i++) { // time comp - O(n) - time complexity is dominated by the loop (O(n))
            System.out.println("n = " + n);
            System.out.println("i = " + i);
            System.out.println("prev = " + prev);
            System.out.println("current = " + current);
            BigInteger next = prev.add(current); // space comp - O(1)
            System.out.println("next = " + next);
            prev = current;
            current = next;
        }

        memo.put(n, current);

        return current;
    }

    @Override
    public Class<BigInteger> getType() {
        return BigInteger.class;
    }
}
