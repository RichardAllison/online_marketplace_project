package com.fdmgroup.marketplace.service.user;

import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.fdmgroup.marketplace.model.user.UserAccount;
import com.fdmgroup.marketplace.repository.CreateTestData;
import com.fdmgroup.marketplace.repository.user.UserAccountDAO;

public class UserAccountServiceTest {
	
	private UserAccountService userAccountService;
	private UserAccount user;
	@Mock
	private UserAccountDAO userAccountDAO;

	@Before
	public void setUp() throws Exception {
		userAccountService = new DefaultUserAccountService(userAccountDAO);
		user = new UserAccount(); 
	}
	
	@Test
	public void test_retrieveOne() {
		user = new UserAccount();
		userAccountService.create(user);
		userAccountService.retrieveOne(1l);
		
	}

	@Test
	public void test_retrieveAll() {
		userAccountService.retrieveAll();
	}

	@Test
	public void test_update() {
		userAccountService.update(user);
	}

	@Test
	public void test_delete() {
		userAccountService.delete(1l);
	}

	@Test
	public void test_getByUsernameAndPassword() {
		userAccountService.getByUsernameAndPassword("username", "password");
	}

}
