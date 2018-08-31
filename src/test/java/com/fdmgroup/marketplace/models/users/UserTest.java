package com.fdmgroup.marketplace.models.users;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.marketplace.models.items.Product;

public class UserTest {
	
	UserAccount user;
	
	@Before
	public void before() {
		user = new UserAccount();
	}
	
	@Test
	public void test_thatUserAccountHasUserId() {
		user.setUserAccountId(1l);
		assertEquals(1l, user.getUserAccountId());
	}
	
	@Test
	public void test_thatUserAccountHasUsername() {
		UserAccount user = new UserAccount();
		String username = "username";
		user.setUsername(username);
		String actual = user.getUsername();
		assertEquals(username, actual);
	}
	
	@Test
	public void test_thatUserAccountHasEmailAddress() {
		UserAccount user = new UserAccount();
		String email = "email@address.com";
		user.setEmailAddress(email);
		String actual = user.getEmailAddress();
		assertEquals(email, actual);	
	}
	
	@Test
	public void test_thatUserAccountHasPassword() {
		String password = "password";
		user.setPassword(password);
		assertEquals(password, user.getPassword());
	}
	
	@Test
	public void test_thatUserAccountCanAddProducts() {
		Product product = new Product();
		user.addProduct(product);
//		assertEquals(product, user.getProducts().get(0));
		assertEquals(1, user.getProducts().size());
	}
	
}
