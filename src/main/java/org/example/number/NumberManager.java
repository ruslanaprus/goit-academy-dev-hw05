package org.example.number;

import org.example.input.NumberSource;

public class NumberManager {
    private final NumberSource numberSource;

    public NumberManager(NumberSource numberSource) {
        this.numberSource = numberSource;
    }

    public int getNumericValue() {
        return numberSource.getNumber();
    }
}