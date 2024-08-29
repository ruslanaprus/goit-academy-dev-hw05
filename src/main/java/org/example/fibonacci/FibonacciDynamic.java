package org.example.fibonacci;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class FibonacciDynamic implements FibonacciStrategy<BigInteger> {
    private static final Map<Integer, BigInteger> memo = new HashMap<>(); // space comp - O(1)
    private static Logger logger = Logger.getLogger(FibonacciDynamic.class.getName());

//    private static final Map<Integer, BigInteger> memo = new ConcurrentHashMap<>();
//static {
//    memo.put(0, BigInteger.ZERO);
//    memo.put(1, BigInteger.ONE);
//}

    @Override
    public BigInteger solveFibonacci(int n) {
        return solveFibonacci(n, null); // Default to null if no TimeUnit is provided
    }

    @Override
    public BigInteger solveFibonacci(int n, TimeUnit timeUnit) {
        long startTime = System.nanoTime();
//        logger.info("Starting computation for Fibonacci number " + n);
        System.out.println("Starting computation for Fibonacci number " + n);
        if (n <= 1) {
            logDuration(n, startTime, timeUnit);
            return BigInteger.valueOf(n);
        }

        BigInteger result = memo.get(n); // time comp - O(1)

        if (result != null) {
            System.out.println("GRABBED FROM MEMO:" + n);
            logDuration(n, startTime, timeUnit);
            return result;
        }

        result = computeFibonacci(n);
        logDuration(n, startTime, timeUnit);
//        return computeFibonacci(n);

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
//        logger.info("Finished computation for Fibonacci number " + n + " in " + duration + " ms");
//        System.out.println("Finished computation for Fibonacci number " + n + " in " + duration + " ms");
        return result;
    }

    private BigInteger computeFibonacci(int n) {
        BigInteger prev = BigInteger.ZERO;
        BigInteger current = BigInteger.ONE;
        for (int i = 2; i <= n; i++) { // time comp - O(n) - time complexity is dominated by the loop (O(n))
            BigInteger next = prev.add(current); // space comp - O(1)
//            System.out.println("n=" + n + " i=" + i + " prev=" + prev + " current=" + current + " next=" + next);
//            System.out.println();
//            System.out.println();
//            System.out.println();
//            System.out.println(" next=" + next);
            prev = current;
            current = next;
        }

        memo.put(n, current);
        return current;
    }

    private void logDuration(int n, long startTime, TimeUnit timeUnit) {
        long endTime = System.nanoTime();
        long duration = timeUnit.convert(endTime - startTime, TimeUnit.NANOSECONDS);
        String unit = timeUnit.toString().toLowerCase();
        String formattedDuration = String.format("%,d", duration).replace(',', '_');
//        logger.info("Finished computation for Fibonacci number " + n + " in " + duration + " " + unit);
//        System.out.println("Finished computation for Fibonacci number " + n + " in " + duration + " " + unit);
        System.out.println("Finished computation for Fibonacci number " + n + " in " + formattedDuration + " " + unit);
    }

    @Override
    public Class<BigInteger> getType() {
        return BigInteger.class;
    }
}
