package com.fdmgroup.marketplace.models.transactions;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.marketplace.models.users.User;

public class SaleTest {
	
	private Sale sale;
	private User seller;
	
	@Before
	public void before() {
		sale = new Sale();
		seller = new User();
	}
	
	@Test
	public void test_thatSaleHasSaleId() {
		sale.setSaleId(1l);
		assertEquals(1l, sale.getSaleId());
	}
	
	@Test
	public void test_thatSaleHasSaleTime() {
		Date expected = new Date();
		sale.setTime(expected);
		assertEquals(expected, sale.getTime());
	}
	
	@Test
	public void test_thatSaleHasSeller() {
		sale.setSeller(seller);
		User actual = sale.getSeller();
		assertEquals(seller, actual);
	}

}
