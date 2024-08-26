package org.example.fibonacci;

import java.math.BigInteger;

public class FibonacciRecursiveMatrixExponentiation implements FibonacciStrategy<BigInteger>{
    @Override
    public BigInteger solveFibonacci(int n) {
        if (n <= 1) {
            return BigInteger.valueOf(n);
        }

        BigInteger[][] F = {
                {BigInteger.ONE, BigInteger.ONE},
                {BigInteger.ONE, BigInteger.ZERO}
        };

        matrixPower(F, n - 1);

        return F[0][0];
    }

    @Override
    public Class<BigInteger> getType() {
        return BigInteger.class;
    }

    private void matrixPower(BigInteger[][] F, int n) {
        if (n == 1 || n == 0) return;

        BigInteger[][] M = {
                {BigInteger.ONE, BigInteger.ONE},
                {BigInteger.ONE, BigInteger.ZERO}
        };

        matrixPower(F, n / 2);
        multiply(F, F);

        if (n % 2 != 0) {
            multiply(F, M);
        }
    }

    private void multiply(BigInteger[][] F, BigInteger[][] M) {
        BigInteger x = F[0][0].multiply(M[0][0]).add(F[0][1].multiply(M[1][0]));
        BigInteger y = F[0][0].multiply(M[0][1]).add(F[0][1].multiply(M[1][1]));
        BigInteger z = F[1][0].multiply(M[0][0]).add(F[1][1].multiply(M[1][0]));
        BigInteger w = F[1][0].multiply(M[0][1]).add(F[1][1].multiply(M[1][1]));

        F[0][0] = x;
        F[0][1] = y;
        F[1][0] = z;
        F[1][1] = w;
    }


//    private static final Map<Integer, WeakReference<BigInteger>> memo = new HashMap<>();
//
//    @Override
//    public BigInteger solveFibonacci(int n) {
//        if (n <= 1) {
//            return BigInteger.valueOf(n);
//        }
//
//        WeakReference<BigInteger> weakReference = memo.get(n);
//        BigInteger result = (weakReference != null) ? weakReference.get() : null;
//
//        if (result != null) {
//            return result;
//        }
//
//        BigInteger[][] F = {
//                {BigInteger.ONE, BigInteger.ONE},
//                {BigInteger.ONE, BigInteger.ZERO}
//        };
//
//        matrixPower(F, n - 1);
//
//        result = F[0][0];
//
//        memo.put(n, new WeakReference<>(result));
//
//        return result;
//    }
//
//    @Override
//    public Class<BigInteger> getType() {
//        return BigInteger.class;
//    }
//
//    private void matrixPower(BigInteger[][] F, int n) {
//        if (n == 1 || n == 0) return;
//
//        BigInteger[][] M = {
//                {BigInteger.ONE, BigInteger.ONE},
//                {BigInteger.ONE, BigInteger.ZERO}
//        };
//
//        matrixPower(F, n / 2);
//        multiply(F, F);
//
//        if (n % 2 != 0) {
//            multiply(F, M);
//        }
//    }
//
//    private void multiply(BigInteger[][] F, BigInteger[][] M) {
//        BigInteger x = F[0][0].multiply(M[0][0]).add(F[0][1].multiply(M[1][0]));
//        BigInteger y = F[0][0].multiply(M[0][1]).add(F[0][1].multiply(M[1][1]));
//        BigInteger z = F[1][0].multiply(M[0][0]).add(F[1][1].multiply(M[1][0]));
//        BigInteger w = F[1][0].multiply(M[0][1]).add(F[1][1].multiply(M[1][1]));
//
//        F[0][0] = x;
//        F[0][1] = y;
//        F[1][0] = z;
//        F[1][1] = w;
//    }
}
