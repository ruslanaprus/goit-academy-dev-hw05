package org.example.fibonacci;

import org.example.logduration.LogHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class FibonacciDynamic implements FibonacciStrategy<BigInteger> {
    private static final Map<Integer, BigInteger> memo = new HashMap<>(); // space comp - O(1)
private static Logger logger = LoggerFactory.getLogger(FibonacciDynamic.class.getName());

//    private static final Map<Integer, BigInteger> memo = new ConcurrentHashMap<>();
//static {
//    memo.put(0, BigInteger.ZERO);
//    memo.put(1, BigInteger.ONE);
//}

    @Override
    public BigInteger solveFibonacci(int n) {
        return solveFibonacci(n, TimeUnit.MILLISECONDS); // Default to null if no TimeUnit is provided
    }

    @Override
    public BigInteger solveFibonacci(int n, TimeUnit timeUnit) {
        LogHelper logHelper = new LogHelper(logger);
        long startTime = System.nanoTime();
        if (n <= 1) {
            logHelper.logDuration(n, startTime, timeUnit);
            return BigInteger.valueOf(n);
        }

        BigInteger result = memo.get(n); // time comp - O(1)

        if (result != null) {
            logHelper.logDuration(n, startTime, timeUnit, "", "memo");
            return result;
        }

        result = computeFibonacci(n);
        logHelper.logDuration(n, startTime, timeUnit);
        return result;
    }

    private BigInteger computeFibonacci(int n) {
        BigInteger prev = BigInteger.ZERO;
        BigInteger current = BigInteger.ONE;
        for (int i = 2; i <= n; i++) { // time comp - O(n) - time complexity is dominated by the loop (O(n))
            BigInteger next = prev.add(current); // space comp - O(1)
            prev = current;
            current = next;
        }

        memo.put(n, current);
        return current;
    }
}
