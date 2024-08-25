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