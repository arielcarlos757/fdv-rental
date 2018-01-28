package com.fdv.rental.bike.repositories.test;

import org.junit.Test;

import com.fdv.rental.bike.core.calculator.CalculatorPrice;
import com.fdv.rental.bike.core.repository.PriceRepository;

public class PriceRepositoryTest {

	@Test(expected = NullPointerException.class)
	public void priceRepositoryNullArg() {
		new PriceRepository(null);
	}
	
	@Test(expected = RuntimeException.class)
	public void priceRepositoryEmptyArg() {
		CalculatorPrice[] arr = new CalculatorPrice[0];
		new PriceRepository(arr);
	}
}
