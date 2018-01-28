package com.fdv.rental.bike.core.calculator;

import java.math.BigDecimal;

public class RegularPriceCalculator implements CalculatorPrice {

	public BigDecimal calculateTotal(double unitaryPrice, int bikesAmount, long timeUnits) {
        BigDecimal subTotal = new BigDecimal(bikesAmount).multiply(new BigDecimal(unitaryPrice));
        return subTotal.multiply(new BigDecimal(timeUnits)).setScale(2, BigDecimal.ROUND_HALF_DOWN);
	}

	public boolean isApplicable(int bikesAmount) {
		return bikesAmount < 3 || bikesAmount > 5;
	}
}
