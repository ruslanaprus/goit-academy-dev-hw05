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
    DYNAMIC_BOTTOM_UP("Dynamic programming with bottom-up approach - Suitable for calculating Fibonacci numbers up to approximately 10 million, higher numbers may cause OutOfMemoryError)") {
        @Override
        public FibonacciStrategy getStrategy() {
            return new FibonacciDynamicBottomUp();
        }
    },
    DYNAMIC("Dynamic Programming - Efficient for calculating Fibonacci numbers up to 5 million") {
        @Override
        public FibonacciStrategy getStrategy() {
            return new FibonacciDynamicIterative();
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