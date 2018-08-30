package com.fdmgroup.marketplace.models.items;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class ProductTest {
	
	private Product product;
	
	@Before
	public void before() {
		product = new Product();
	}
	
	@Test
	public void test_thatProductHasPrice() {
		product.setPrice(BigDecimal.valueOf(10));
		BigDecimal expected = BigDecimal.valueOf(10);
		BigDecimal actual = product.getPrice();
		assertEquals(expected, actual);
	}
	
	@Test
	public void test_thatProductHasQuantity() {
		product.setQuantity(2);
		int expected = 2;
		int actual = product.getQuantity();
		assertEquals(expected, actual);
	}

}
