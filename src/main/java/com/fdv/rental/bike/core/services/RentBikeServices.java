package com.fdv.rental.bike.core.services;

import static com.fdv.rental.bike.core.utils.ValidateUtils.checkIfFalse;
import static com.fdv.rental.bike.core.utils.ValidateUtils.checkNotNull;
import com.fdv.rental.bike.core.domain.rent.RentType;
import com.fdv.rental.bike.core.repository.PriceRepository;

public class RentBikeServices {

	private PriceRepository priceRepository;
	
	public RentBike rent(final RentType type, final int amountBike, final long time) {
		checkNotNull(type, "Rent's type cant be null");
		checkIfFalse(amountBike > 0, "Rent's duration cant be less than one");
		checkIfFalse(time > 0, "Bikes amount must be greater than zero");
		return new RentBike(type, 
							amountBike, 
							time, 
							priceRepository.calculate(type, amountBike, time));
	}
	
	public RentBikeServices(PriceRepository repository) {
		checkNotNull(repository, "The repository cannot be null");
		this.priceRepository = repository;
	}
}
