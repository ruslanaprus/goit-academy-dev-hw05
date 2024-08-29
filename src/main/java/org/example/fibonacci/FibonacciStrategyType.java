package org.example.fibonacci;

public enum FibonacciStrategyType {
    RECURSIVE("Recursive - Best suited for calculating Fibonacci numbers up to 50") {
        @Override
        public FibonacciStrategy getStrategy() {
            return new FibonacciRecursive();
        }
    },
    ITERATIVE("Iterative - Efficient for calculating Fibonacci numbers up to 5 million") {
        @Override
        public FibonacciStrategy getStrategy() {
            return new FibonacciIterative();
        }
    },
    DYNAMIC("Dynamic Programming - Efficient for calculating Fibonacci numbers up to 5 million") {
        @Override
        public FibonacciStrategy getStrategy() {
            return new FibonacciDynamic();
        }
    },
    DYNAMIC_MATRIX_EXPONENTIATION("Dynamic programming with matrix exponentiation - Suitable for calculating Fibonacci numbers up to approximately 100 million)") {
        @Override
        public FibonacciStrategy getStrategy() {
            return new FibonacciDynamicMatrixExp();
        }
    },
    RECURSIVE_MATRIX_EXPONENTIATION("Recursive matrix exponentiation - Suitable for calculating Fibonacci numbers up to approximately 100 million") {
        @Override
        public FibonacciStrategy getStrategy() {
            return new FibonacciRecursiveMatrixExponentiation();
        }
    },
    MATRIX_EXPONENTIATION("Matrix exponentiation - Highly efficient for calculating large Fibonacci numbers up to the maximum integer value") {
        @Override
        public FibonacciStrategy getStrategy() {
            return new FibonacciMatrixExponentiation();
        }
    };

    private final String description;

    FibonacciStrategyType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public abstract FibonacciStrategy getStrategy();
}