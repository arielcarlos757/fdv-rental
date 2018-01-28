package com.fdv.rental.bike.services.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

import com.fdv.rental.bike.core.calculator.CalculatorPrice;
import com.fdv.rental.bike.core.calculator.PromotionalPriceCalculator;
import com.fdv.rental.bike.core.calculator.RegularPriceCalculator;
import com.fdv.rental.bike.core.domain.rent.RentType;
import com.fdv.rental.bike.core.repository.PriceRepository;
import com.fdv.rental.bike.core.services.RentBike;
import com.fdv.rental.bike.core.services.RentBikeServices;


/**
 * cobertura:cobertura -e -X
 * */
public class RentBikeServicesTest {
	
	private RentBikeServices services;
	
	private final int NEGATIVE = -1;
	private final int ZERO = 0;
	
	private final int ONE_BIKE = 1;
	private final int TWO_BIKES = 2;
	private final int THREE_BIKES = 3;
	private final int FOUR_BIKES = 4;
	private final int SIX_BIKES = 6;
	
	private final int ONE_DAY = 1;
	private final int TWO_DAYS = 2;
	
	
	private final long FOUR_HOURS = 4;
	private final long TWO_HOURS = 2;
	
	

	@Test
	public void oneBikeTest() {
		prepare();
		RentBike rent = services.rent(RentType.HOUR, ONE_BIKE, FOUR_HOURS);
		assertThat(rent.getAmountBike()).isEqualTo(ONE_BIKE);
		assertThat(rent.getTime()).isEqualTo(FOUR_HOURS);
		assertThat(rent.getType()).isEqualTo(RentType.HOUR);
		assertThat(rent.getTotal()).isEqualTo(new BigDecimal(20).setScale(2, BigDecimal.ROUND_UNNECESSARY));
	}
	
	@Test
	public void twoBikeTest() {
		prepare();
		RentBike rent = services.rent(RentType.HOUR, TWO_BIKES, FOUR_HOURS);
		assertThat(rent.getAmountBike()).isEqualTo(TWO_BIKES);
		assertThat(rent.getTime()).isEqualTo(FOUR_HOURS);
		assertThat(rent.getType()).isEqualTo(RentType.HOUR);
		assertThat(rent.getTotal()).isEqualTo(new BigDecimal(40).setScale(2, BigDecimal.ROUND_UNNECESSARY));
	}
	
	
	@Test
	public void threeBikeApplyDiscountTest() { 
		prepare();
		RentBike rent = services.rent(RentType.HOUR, THREE_BIKES, FOUR_HOURS);
		assertThat(rent.getAmountBike()).isEqualTo(THREE_BIKES);
		assertThat(rent.getTime()).isEqualTo(FOUR_HOURS);
		assertThat(rent.getType()).isEqualTo(RentType.HOUR);
		assertThat(rent.getTotal()).isEqualTo(new BigDecimal(42).setScale(2, BigDecimal.ROUND_UNNECESSARY));
	}
	
	@Test
	public void sixBikeNoApplyDiscountTest() { 
		prepare();
		RentBike rent = services.rent(RentType.HOUR, SIX_BIKES, FOUR_HOURS);
		assertThat(rent.getAmountBike()).isEqualTo(SIX_BIKES);
		assertThat(rent.getTime()).isEqualTo(FOUR_HOURS);
		assertThat(rent.getType()).isEqualTo(RentType.HOUR);
		assertThat(rent.getTotal()).isEqualTo(new BigDecimal(120).setScale(2, BigDecimal.ROUND_UNNECESSARY));
	}
	
	
	@Test
	public void oneBikeOneDayTest() {
		prepare();
		RentBike rent = services.rent(RentType.DAY, ONE_BIKE, ONE_DAY);
		assertThat(rent.getAmountBike()).isEqualTo(ONE_BIKE);
		assertThat(rent.getTime()).isEqualTo(ONE_DAY);
		assertThat(rent.getType()).isEqualTo(RentType.DAY);
		assertThat(rent.getTotal()).isEqualTo(new BigDecimal(20).setScale(2, BigDecimal.ROUND_UNNECESSARY));
	}

	
	@Test
	public void twoBikeTwoDaysTest() {
		prepare();
		RentBike rent = services.rent(RentType.DAY, TWO_BIKES, TWO_DAYS);
		assertThat(rent.getAmountBike()).isEqualTo(TWO_BIKES);
		assertThat(rent.getTime()).isEqualTo(TWO_DAYS);
		assertThat(rent.getType()).isEqualTo(RentType.DAY);
		assertThat(rent.getTotal()).isEqualTo(new BigDecimal(80).setScale(2, BigDecimal.ROUND_UNNECESSARY));
	}
	
	@Test
	public void fourBikeTwoDaysTest() {
		prepare();
		RentBike rent = services.rent(RentType.DAY, FOUR_BIKES, TWO_DAYS);
		assertThat(rent.getAmountBike()).isEqualTo(FOUR_BIKES);
		assertThat(rent.getTime()).isEqualTo(TWO_DAYS);
		assertThat(rent.getType()).isEqualTo(RentType.DAY);
		assertThat(rent.getTotal()).isEqualTo(new BigDecimal(112).setScale(2, BigDecimal.ROUND_UNNECESSARY));
	}
	
	
	@Test
	public void oneBikeOneWeekTest() {
		prepare();
		RentBike rent = services.rent(RentType.WEEK, ONE_BIKE, FOUR_HOURS);
		assertThat(rent.getAmountBike()).isEqualTo(ONE_BIKE);
		assertThat(rent.getTime()).isEqualTo(FOUR_HOURS);
		assertThat(rent.getType()).isEqualTo(RentType.WEEK);
		assertThat(rent.getTotal()).isEqualTo(new BigDecimal(240).setScale(2, BigDecimal.ROUND_UNNECESSARY));
	}
	
	@Test
	public void oneBikeTwoWeekTest() {
		prepare();
		RentBike rent = services.rent(RentType.WEEK, TWO_BIKES, TWO_HOURS);
		assertThat(rent.getAmountBike()).isEqualTo(TWO_BIKES);
		assertThat(rent.getTime()).isEqualTo(TWO_HOURS);
		assertThat(rent.getType()).isEqualTo(RentType.WEEK);
		assertThat(rent.getTotal()).isEqualTo(new BigDecimal(240).setScale(2, BigDecimal.ROUND_UNNECESSARY));
	}
	
	@Test
	public void threeBikeTwoWeekDiscountTest() {
		prepare();
		RentBike rent = services.rent(RentType.WEEK, THREE_BIKES, TWO_HOURS);
		assertThat(rent.getAmountBike()).isEqualTo(THREE_BIKES);
		assertThat(rent.getTime()).isEqualTo(TWO_HOURS);
		assertThat(rent.getType()).isEqualTo(RentType.WEEK);
		assertThat(rent.getTotal()).isEqualTo(new BigDecimal(252).setScale(2, BigDecimal.ROUND_UNNECESSARY));
	}
	
	@Test
	public void sixBikeTwoWeekWithoutDiscountTest() {
		prepare();
		RentBike rent = services.rent(RentType.WEEK, SIX_BIKES, TWO_HOURS);
		assertThat(rent.getAmountBike()).isEqualTo(SIX_BIKES);
		assertThat(rent.getTime()).isEqualTo(TWO_HOURS);
		assertThat(rent.getType()).isEqualTo(RentType.WEEK);
		assertThat(rent.getTotal()).isEqualTo(new BigDecimal(720).setScale(2, BigDecimal.ROUND_UNNECESSARY));
	}
	
	@Test(expected = RuntimeException.class)
	public void negativeValueForBikeTest() {
		prepare();
		RentBike rent = services.rent(RentType.WEEK, NEGATIVE, TWO_HOURS);
	}
	
	@Test(expected = RuntimeException.class)
	public void negativeValueForHourTest() {
		prepare();
		RentBike rent = services.rent(RentType.WEEK, SIX_BIKES, NEGATIVE);
	}
	
	@Test(expected = RuntimeException.class)
	public void zeroValueForHourTest() {
		prepare();
		RentBike rent = services.rent(RentType.WEEK, SIX_BIKES, ZERO);
	}
	
	@Test(expected = RuntimeException.class)
	public void zeroValueForBikeTest() {
		prepare();
		RentBike rent = services.rent(RentType.WEEK, ZERO, TWO_HOURS);
	}
	
	
	@Test(expected = RuntimeException.class)
	public void nullValueForRentTest() {
		prepare();
		RentBike rent = services.rent(null, SIX_BIKES, TWO_HOURS);
	}
	
	
	private void prepare() {
		CalculatorPrice[] calculators = { new RegularPriceCalculator(), 
				new PromotionalPriceCalculator(new RegularPriceCalculator()) };
		PriceRepository repositories = new PriceRepository(calculators);
		services = new RentBikeServices(repositories);
	}
}
