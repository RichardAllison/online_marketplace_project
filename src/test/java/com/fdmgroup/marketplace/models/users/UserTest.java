package com.fdmgroup.marketplace.models.users;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.fdmgroup.marketplace.models.items.Item;

public class UserTest {
	
	@Test
	public void test_thatUserHasUsername() {
		User user = new User();
		user.setUsername("username");
		String expected = "username";
		String actual = user.getUsername();
		assertEquals(expected, actual);
	}

}
