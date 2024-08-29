package org.example.fibonacci;

import org.junit.jupiter.api.Disabled;
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

    private static BigInteger getExpectedFibonacci(int n) {
        return switch (n) {
            case 0 -> BigInteger.ZERO;
            case 1 -> BigInteger.ONE;
            case 2 -> BigInteger.ONE;
            case 10 -> BigInteger.valueOf(55);
            case 50 -> new BigInteger("12586269025");
            case 70 -> new BigInteger("190392490709135");
            case 100 -> new BigInteger("354224848179261915075");
            case 120 -> new BigInteger("5358359254990966640871840");
            case 1000 -> new BigInteger("43466557686937456435688527675040625802564660517371780402481729089536555417949051890403879840079255169295922593080322634775209689623239873322471161642996440906533187938298969649928516003704476137795166849228875");
            // Add more cases as needed
            default -> throw new IllegalArgumentException("Unexpected value: " + n);
        };
    }

//    @ParameterizedTest
//    @ValueSource(ints = {0, 1, 2, 10, 20, 50})
//    void testSolveFibonacci(int n) {
//        FibonacciDynamic fibonacci = new FibonacciDynamic();
//        BigInteger result = fibonacci.solveFibonacci(n);
//        // Add assertions based on expected results
//
//    }

    @ParameterizedTest
//    @ValueSource(ints = {0, 1, 2, 10, 10, 10, 10, 10, 10, 10, 10})
    @ValueSource(ints = {0, 0, 0, 50, 50, 50, 70, 70, 100, 100, 1000, 1000, 100, 70, 70, 50, 50, 0, 0})
    void testSolveFibonacci(int n) {
        FibonacciDynamic fibonacci = new FibonacciDynamic();
        BigInteger result = fibonacci.solveFibonacci(n, TimeUnit.NANOSECONDS);

        BigInteger expected = getExpectedFibonacci(n);
        assertEquals(expected, result);
    }

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

    @Test
    @DisplayName("Fibonacci:5=5")
    void testSolveFibonacci() {
        int input = 5;
        FibonacciDynamic fibonacci = new FibonacciDynamic();
        BigInteger result = fibonacci.solveFibonacci(input);
        assertEquals(BigInteger.valueOf(5), result);
    }

    @Test
    @DisplayName("Fibonacci:6=8")
//    @Disabled
    void testSolveFibonacciSix() {
        int input = 6;
        FibonacciDynamic fibonacci = new FibonacciDynamic();
        BigInteger result = fibonacci.solveFibonacci(input, TimeUnit.MILLISECONDS);
        assertEquals(BigInteger.valueOf(8), result);
    }
}
