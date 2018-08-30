package com.fdmgroup.marketplace.models.users;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.marketplace.models.items.Product;

public class UserTest {
	
	User user;
	
	@Before
	public void before() {
		user = new User();
	}
	
	@Test
	public void test_thatUserHasUserId() {
		user.setUserId(1l);
		assertEquals(1l, user.getUserId());
	}
	
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
	
	@Test
	public void test_thatUserHasPassword() {
		String password = "password";
		user.setPassword("password");
	}
	
	@Test
	public void test_thatUserCanAddProducts() {
		Product product = new Product();
		user.addProduct(product);
		assertEquals(product, user.getProducts().get(0));
		assertEquals(1, user.getProducts().size());
	}
	
}
