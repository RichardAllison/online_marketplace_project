package com.fdmgroup.marketplace.service.user;

import javax.persistence.EntityManager;

import com.fdmgroup.marketplace.model.user.UserAccount;
import com.fdmgroup.marketplace.repository.CRUD;
import com.fdmgroup.marketplace.repository.user.UserAccountDAO;

public class DefaultUserAccountService implements UserAccountService {
	CRUD<UserAccount> userAccountDAO;
	
	DefaultUserAccountService(EntityManager entityManager) {
		userAccountDAO = new UserAccountDAO(entityManager);
	}
}
