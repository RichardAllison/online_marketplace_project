package com.fdmgroup.marketplace.model.user;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.marketplace.model.item.Item;
import com.fdmgroup.marketplace.model.transaction.purchase.Purchase;
import com.fdmgroup.marketplace.model.transaction.sale.Sale;
import com.fdmgroup.marketplace.model.user.UserAccount;

public class UserAccountTest {
	
	UserAccount user;
	
	@Before
	public void before() {
		user = new UserAccount();
	}
	
	@Test
	public void test_thatUserAccountHasUserId() {
		user.setId(1l);
		assertEquals(1l, user.getId());
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
	public void test_thatUserAccountCanAddProduct() {
		Item item = new Item();
		user.addItem(item);
//		assertEquals(product, user.getProducts().get(0));
		assertEquals(1, user.getProducts().size());
	}
	
	@Test
	public void test_thatUserAccountCanRemoveProduct() {
		Item item = new Item();
		user.addItem(item);
		user.removeItem(item);
		assertEquals(0, user.getProducts().size());
	}
	
	@Test
	public void test_thatOrdersCanBeAddedToUserAccountPurchases() {
		Purchase purchase = new Purchase();
		user.addToPurchases(purchase);
		assertEquals(1, user.getPurchases().size());
	}
	
	@Test
	public void test_thatOrdersCanBeAddedToUserAccountSales() {
		Sale sale = new Sale();
		user.addToSales(sale);
		assertEquals(1, user.getSales().size());
	}
}
