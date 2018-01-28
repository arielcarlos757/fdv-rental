package com.fdv.rental.bike.core.repository;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import com.fdv.rental.bike.core.calculator.CalculatorPrice;
import com.fdv.rental.bike.core.domain.rent.RentType;
import static com.fdv.rental.bike.core.utils.ValidateUtils.checkNotNull;
import static com.fdv.rental.bike.core.utils.ValidateUtils.checkIsEmpty;

public class PriceRepository {

	private  List<CalculatorPrice> calculator;
	
	public BigDecimal calculate(final RentType type, final int amountBike, final long timeUnits) {
		BigDecimal result = null;
		for(CalculatorPrice c : calculator) {
			if(c.isApplicable(amountBike)) {
				result = c.calculateTotal(type.getPrice(), amountBike, timeUnits);
			}
		}
		return result;
	}
	
	public PriceRepository(CalculatorPrice[] calculators) {
		checkNotNull(calculators, "The calculators cannot be null");
		checkIsEmpty(Arrays.asList(calculators), "The calculators cannot be empty");
		this.calculator = Arrays.asList(calculators);
	}
}
