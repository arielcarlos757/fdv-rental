package com.fdv.rental.bike.core.domain.rent;

public enum RentType implements Prices {
	HOUR {
		public double getPrice() {
			return 5d;
		}
	},
	DAY {
		public double getPrice() {
			return 20d;
		}
	},
	WEEK {
		public double getPrice() {
			return 60d;
		}
	};
}
