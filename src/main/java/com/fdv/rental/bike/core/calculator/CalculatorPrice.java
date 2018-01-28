package com.fdv.rental.bike.core.calculator;

import java.math.BigDecimal;

public interface CalculatorPrice {

    BigDecimal calculateTotal(double unitaryPrice, int bikesAmount, long timeUnits);
    boolean isApplicable(int bikesAmount);
}
