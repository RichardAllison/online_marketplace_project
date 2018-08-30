package com.fdmgroup.marketplace.models.transactions;

import java.util.Date;

import com.fdmgroup.marketplace.models.users.User;

public class Sale {

	private long saleId;
	private User seller;
	private Date time;

	public long getSaleId() {
		return saleId;
	}

	public void setSaleId(long saleId) {
		this.saleId = saleId;
	}

	public User getSeller() {
		return seller;
	}

	public void setSeller(User seller) {
		this.seller = seller;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
