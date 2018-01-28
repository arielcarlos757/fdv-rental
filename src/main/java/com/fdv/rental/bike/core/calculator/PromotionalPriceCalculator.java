package com.fdv.rental.bike.core.calculator;

import java.math.BigDecimal;
import static com.fdv.rental.bike.core.utils.ValidateUtils.checkNotNull;


public class PromotionalPriceCalculator implements CalculatorPrice {

	private CalculatorPrice regularPriceCalculator;
	
	public BigDecimal calculateTotal(double unitaryPrice, int bikesAmount, long timeUnits) {
		BigDecimal price = regularPriceCalculator.calculateTotal(unitaryPrice, bikesAmount, timeUnits);
		return price.multiply(new BigDecimal(0.7d)).setScale(2, BigDecimal.ROUND_HALF_DOWN);
	}

	public boolean isApplicable(int bikesAmount) {
		return bikesAmount >= 3 && bikesAmount <= 5;
	}
	
	public PromotionalPriceCalculator(CalculatorPrice regular) {
		checkNotNull(regular, "The regular calculator price cannot be null");
		this.regularPriceCalculator = regular;
	}
}
