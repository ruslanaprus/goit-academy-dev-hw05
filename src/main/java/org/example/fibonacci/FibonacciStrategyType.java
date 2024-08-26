package org.example.fibonacci;

public enum FibonacciStrategyType {
    RECURSIVE("Recursive") {
        @Override
        public FibonacciStrategy getStrategy() {
            return new FibonacciRecursive();
        }
    },
    ITERATIVE("Iterative") {
        @Override
        public FibonacciStrategy getStrategy() {
            return new FibonacciIterative();
        }
    },
    DYNAMIC("Dynamic Programming") {
        @Override
        public FibonacciStrategy getStrategy() {
            return new FibonacciDynamic();
        }
    },
    MATRIX_EXPONENTIATION("Matrix exponentiation (uses BigDecimal, really good for large numbers)") {
        @Override
        public FibonacciStrategy getStrategy() {
            return new FibonacciMatrixExponentiation();
        }
    },
    RECURSIVE_MATRIX_EXPONENTIATION("Recursive matrix exponentiation (good for relatively small numbers: up to around 100_000_000)") {
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