package org.example.number;

import java.math.MathContext;
import java.math.RoundingMode;

public class Constants {
    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = Integer.MAX_VALUE;
    public static final MathContext MATH_CONTEXT = new MathContext(105, RoundingMode.HALF_UP);
}
