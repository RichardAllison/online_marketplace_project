package com.fdmgroup.marketplace.models.transactions;

import java.math.BigDecimal;
import java.util.Date;

public abstract class Basket {

	private Date time;
	
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}

	public abstract BigDecimal calculateTotalCost();
}
