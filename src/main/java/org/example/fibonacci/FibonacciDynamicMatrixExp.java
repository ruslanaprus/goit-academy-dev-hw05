package org.example.fibonacci;

import java.math.BigInteger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FibonacciDynamicMatrixExp implements FibonacciStrategy<BigInteger> {
    private static final Map<Integer, BigInteger> memo = new ConcurrentHashMap<>(); // space comp for the memoization map is O(n)

    @Override
    public BigInteger solveFibonacci(int n) {
        if (n <= 1) {
            return BigInteger.valueOf(n);
        }
        return fibonacci(n);
    }

    private BigInteger fibonacci(int n) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        // space used by the matrices is constant - O(1)
        BigInteger[][] result = {{BigInteger.ONE, BigInteger.ZERO}, {BigInteger.ZERO, BigInteger.ONE}};
        BigInteger[][] base = {{BigInteger.ONE, BigInteger.ONE}, {BigInteger.ONE, BigInteger.ZERO}};
        int power = n;

        while (power > 0) { // time comp of matrix exponentiation is O(log n)
            if (power % 2 != 0) {
                result = multiplyMatrix(result, base);
            }
            base = multiplyMatrix(base, base);
            power /= 2;
        }

        BigInteger fibonacciNumber = result[0][1];
        memo.put(n, fibonacciNumber);
        return fibonacciNumber;
    }

    private BigInteger[][] multiplyMatrix(BigInteger[][] A, BigInteger[][] B) { // Each matrix multiplication operation is O(1)
        BigInteger[][] C = new BigInteger[2][2];
        C[0][0] = A[0][0].multiply(B[0][0]).add(A[0][1].multiply(B[1][0]));
        C[0][1] = A[0][0].multiply(B[0][1]).add(A[0][1].multiply(B[1][1]));
        C[1][0] = A[1][0].multiply(B[0][0]).add(A[1][1].multiply(B[1][0]));
        C[1][1] = A[1][0].multiply(B[0][1]).add(A[1][1].multiply(B[1][1]));
        return C;
    }

    @Override
    public Class<BigInteger> getType() {
        return BigInteger.class;
    }
}