package com.fdmgroup.marketplace.models.items;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class ProductTest {
	
	@Test
	public void test_thatProductHasPrice() {
		Product product = new Product();
		product.setPrice(BigDecimal.valueOf(10));
		BigDecimal expected = BigDecimal.valueOf(10);
		BigDecimal actual = product.getPrice();
		assertEquals(expected, actual);
	}

}
