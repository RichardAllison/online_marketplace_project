package com.fdmgroup.marketplace.models.users;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UserTest {
	
	@Test
	public void test_thatUserHasUsername() {
		User user = new User();
		String username = "username";
		user.setUsername(username);
		String actual = user.getUsername();
		assertEquals(username, actual);
	}
	
	@Test
	public void test_thatUserHasEmailAddress() {
		User user = new User();
		String email = "email@address.com";
		user.setEmailAddress(email);
		String actual = user.getEmailAddress();
		assertEquals(email, actual);	
	}

}
