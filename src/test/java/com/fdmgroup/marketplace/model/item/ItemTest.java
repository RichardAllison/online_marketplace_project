package com.fdmgroup.marketplace.model.item;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.marketplace.model.item.Item;
import com.fdmgroup.marketplace.model.user.UserAccount;

public class ItemTest {
	
	private Item item;
	
	@Before
	public void before() {
		item = new Item();
	}
	
	@Test
	public void test_thatProductHasPrice() {
		item.setPrice(BigDecimal.valueOf(10));
		BigDecimal expected = BigDecimal.valueOf(10);
		BigDecimal actual = item.getPrice();
		assertEquals(expected, actual);
	}
	
	@Test
	public void test_thatItemHasName() {
		String name = "item"; 
		item.setName(name);
		assertEquals(name, item.getName());
	}
	
	@Test
	public void test_thatItemHasDescription() {
		String description = "description";
		item.setDescription(description);
		assertEquals(description, item.getDescription());
	}
	
	@Test
	public void test_thatItemHasSeller() {
		UserAccount seller = new UserAccount();
		item.setSeller(seller);
		assertEquals(seller, item.getSeller());
	}
}
