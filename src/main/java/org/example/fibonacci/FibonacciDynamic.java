package org.example.fibonacci;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class FibonacciDynamic implements FibonacciStrategy<BigInteger> {
    private static final Map<Integer, BigInteger> memo = new HashMap<>(); // space comp - O(1)
//    private static final Map<Integer, BigInteger> memo = new ConcurrentHashMap<>();
//static {
//    memo.put(0, BigInteger.ZERO);
//    memo.put(1, BigInteger.ONE);
//}

    @Override
    public BigInteger solveFibonacci(int n) {
        if (n <= 1) {
            return BigInteger.valueOf(n);
        }

        BigInteger result = memo.get(n); // time comp - O(1)

        if (result != null) {
            return result;
        }

        return computeFibonacci(n);
    }

    private BigInteger computeFibonacci(int n) {
        BigInteger prev = BigInteger.ZERO;
        BigInteger current = BigInteger.ONE;
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
