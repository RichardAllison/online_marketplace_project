package com.fdmgroup.marketplace.models.items;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class ItemTest {
	
	@Test
	public void test_thatItemHasPrice() {
		Item item = new Item();
		item.setPrice(BigDecimal.valueOf(10));
		BigDecimal expected = BigDecimal.valueOf(10);
		BigDecimal actual = item.getPrice();
		assertEquals(expected, actual);
	}

}
