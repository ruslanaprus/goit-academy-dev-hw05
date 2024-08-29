package org.example.fibonacci;

import org.openjdk.jmh.annotations.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.TimeUnit;

@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 2, jvmArgs = {"-Xms2G", "-Xmx2G"}) // will fork the benchmark twice, with each fork running in its own JVM instance with 2GB of heap memory
@Warmup(iterations = 3)
@Measurement(iterations = 3)
@State(Scope.Thread)
public class FibonacciBenchmark {

    @Param({"100", "1000"})
    private int n;

    // don't use n>50 for this benchmark
//    @Benchmark
//    public BigInteger testFibonacciRecursive() {
//        FibonacciRecursive fibonacciRecursive = new FibonacciRecursive();
//        return fibonacciRecursive.solveFibonacci(n);
//    }

    // can handle n=10_000_000 (it would take at least 14 minutes)
    @Benchmark
    public BigInteger testFibonacciIterative() {
        FibonacciIterative fibonacciIterative = new FibonacciIterative();
        return fibonacciIterative.solveFibonacci(n);
    }

    // can handle n=10_000_000
    @Benchmark
    public BigInteger testFibonacciDynamic() {
        FibonacciDynamic fibonacciDynamic = new FibonacciDynamic();
        return fibonacciDynamic.solveFibonacci(n);
    }

    // calculates 2147483647-th value in Fibonacci sequence in 12 minutes
    @Benchmark
    public BigDecimal testFibonacciMatrixExp() {
        FibonacciMatrixExponentiation fibonacciMatrixExponentiation = new FibonacciMatrixExponentiation();
        return fibonacciMatrixExponentiation.solveFibonacci(n);
    }

    // can handle n=100_000_000 (result in about 90 seconds)
    @Benchmark
    public BigInteger testFibonacciRecMatrixExp() {
        FibonacciRecursiveMatrixExponentiation fibonacciRecursiveMatrixExponentiation = new FibonacciRecursiveMatrixExponentiation();
        return fibonacciRecursiveMatrixExponentiation.solveFibonacci(n);
    }
}
