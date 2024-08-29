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
    DYNAMIC_BOTTOM_UP("Dynamic programming with bottom-up approach - Suitable for calculating Fibonacci numbers up to approximately 10 million") {
        @Override
        public FibonacciStrategy getStrategy() {
            return new FibonacciDynamicBottomUp();
        }
    },
    MATRIX_EXPONENTIATION("Matrix exponentiation - Suitable for calculating Fibonacci numbers up to the maximum integer value") {
        @Override
        public FibonacciStrategy getStrategy() {
            return new FibonacciMatrixExponentiation();
        }
    },
    RECURSIVE_MATRIX_EXPONENTIATION("Recursive matrix exponentiation - Highly efficient for calculating large Fibonacci numbers up to the maximum integer value") {
        @Override
        public FibonacciStrategy getStrategy() {
            return new FibonacciRecursiveMatrixExponentiation();
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