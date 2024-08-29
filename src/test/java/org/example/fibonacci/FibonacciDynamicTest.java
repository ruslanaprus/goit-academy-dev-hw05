package org.example.fibonacci;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciDynamicTest {
//    @ParameterizedTest
//    @ValueSource(ints = {0, 1, 2, 10, 20, 50})
//    void testSolveFibonacci(int n) {
//        FibonacciDynamic fibonacci = new FibonacciDynamic();
//        BigInteger result = fibonacci.solveFibonacci(n);
//        // Add assertions based on expected results
//
//    }

//    @Test
//    void testNegativeInput() {
//        FibonacciDynamic fibonacci = new FibonacciDynamic();
//        assertThrows(IllegalArgumentException.class, () -> fibonacci.solveFibonacci(-1));
//    }

//    @Test
//    void testConcurrentAccess() throws InterruptedException {
//        FibonacciDynamic fibonacci = new FibonacciDynamic();
//        ExecutorService executor = Executors.newFixedThreadPool(10);
//        List<Future<BigInteger>> futures = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            futures.add(executor.submit(() -> fibonacci.solveFibonacci(50)));
//        }
//        for (Future<BigInteger> future : futures) {
//            assertNotNull(future.get());
//        }
//        executor.shutdown();
//    }

//    @Test
//    @DisplayName("Fibonacci:5")
//    void testSolveFibonacci() {
//        int input = 5;
//        FibonacciDynamic fibonacci = new FibonacciDynamic();
//        BigInteger result = fibonacci.solveFibonacci(input);
//        assertEquals(BigInteger.valueOf(5), result);
//    }

    @Test
    @DisplayName("Fibonacci:6=8")
    void testSolveFibonacciSix() {
//        int input = 6;
        int input = 100;
        FibonacciDynamic fibonacci = new FibonacciDynamic();
        BigInteger result = fibonacci.solveFibonacci(input, TimeUnit.MILLISECONDS);
//        assertEquals(BigInteger.valueOf(8), result);
        String bob = "354224848179261915075";
        assertEquals(new BigInteger(bob), result);
    }
}
