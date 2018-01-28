package com.fdv.rental.bike.core.services;

import java.math.BigDecimal;

import com.fdv.rental.bike.core.domain.rent.RentType;

public class RentBike {
	
	private RentType type;
	private int amountBike;
	private long time;
	private BigDecimal total;

	public RentBike(final RentType type, final int amountBike, final long time, final BigDecimal total) {
		this.type = type;
		this.amountBike = amountBike;
		this.time = time;
		this.total = total;
	}

	public RentType getType() {
		return type;
	}

	public void setType(RentType type) {
		this.type = type;
	}

	public int getAmountBike() {
		return amountBike;
	}

	public void setAmountBike(int amountBike) {
		this.amountBike = amountBike;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	
	
}
