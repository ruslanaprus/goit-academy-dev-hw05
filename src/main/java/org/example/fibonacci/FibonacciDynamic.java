package org.example.fibonacci;

import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.HashMap;
import java.util.Map;

public class FibonacciDynamic implements FibonacciStrategy {
//    private static final Map<Integer, WeakReference<BigInteger>> memo = new HashMap<>(); // space comp - O(n), due to the use of WeakReference, the actual space might be less because some entries could be garbage collected
//
//    @Override
//    public BigInteger solveFibonacci(int n) {
//        if (n <= 1) {
//            return BigInteger.valueOf(n);
//        }
//
//        WeakReference<BigInteger> weakReference = memo.get(n); // time comp - O(1)
//        BigInteger result = (weakReference != null) ? weakReference.get() : null; // time comp - O(1)
//
//        if (result != null) {
//            return result;
//        }
//
//        BigInteger prev = BigInteger.ZERO; // space comp - O(1)
//        BigInteger current = BigInteger.ONE; // space comp - O(1)
//
//        for (int i = 2; i <= n; i++) { // time comp - O(n) - time complexity is dominated by the loop (O(n))
//            BigInteger next = prev.add(current); // space comp - O(1)
//            prev = current;
//            current = next;
//        }
//
//        memo.put(n, new WeakReference<>(current));
//
//        return current;
//    }
private static final Map<Integer, WeakReference<BigDecimal>> memo = new HashMap<>();
    private static final MathContext MATH_CONTEXT = new MathContext(100); // Adjust precision as needed

    public BigDecimal solveFibonacci(int n) {
        if (n <= 1) {
            return BigDecimal.valueOf(n);
        }

        WeakReference<BigDecimal> weakReference = memo.get(n);
        BigDecimal result = (weakReference != null) ? weakReference.get() : null;

        if (result != null) {
            return result;
        }

        BigDecimal[][] F = {
                {BigDecimal.ONE, BigDecimal.ONE},
                {BigDecimal.ONE, BigDecimal.ZERO}
        };
        power(F, n - 1);

        result = F[0][0];
        memo.put(n, new WeakReference<>(result));

        return result;
    }

    private void power(BigDecimal[][] F, int n) {
        BigDecimal[][] M = {
                {BigDecimal.ONE, BigDecimal.ONE},
                {BigDecimal.ONE, BigDecimal.ZERO}
        };

        for (int i = 2; i <= n; i++) {
            multiply(F, M);
        }
    }

    private void multiply(BigDecimal[][] F, BigDecimal[][] M) {
        BigDecimal x = F[0][0].multiply(M[0][0], MATH_CONTEXT).add(F[0][1].multiply(M[1][0], MATH_CONTEXT), MATH_CONTEXT);
        BigDecimal y = F[0][0].multiply(M[0][1], MATH_CONTEXT).add(F[0][1].multiply(M[1][1], MATH_CONTEXT), MATH_CONTEXT);
        BigDecimal z = F[1][0].multiply(M[0][0], MATH_CONTEXT).add(F[1][1].multiply(M[1][0], MATH_CONTEXT), MATH_CONTEXT);
        BigDecimal w = F[1][0].multiply(M[0][1], MATH_CONTEXT).add(F[1][1].multiply(M[1][1], MATH_CONTEXT), MATH_CONTEXT);

        F[0][0] = x;
        F[0][1] = y;
        F[1][0] = z;
        F[1][1] = w;
    }
}
