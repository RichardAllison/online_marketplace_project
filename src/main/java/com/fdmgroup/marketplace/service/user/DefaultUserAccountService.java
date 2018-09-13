package com.fdmgroup.marketplace.service.user;

import java.util.List;

import javax.persistence.EntityManager;

import com.fdmgroup.marketplace.model.user.UserAccount;
import com.fdmgroup.marketplace.repository.user.UserAccountDAO;

public class DefaultUserAccountService implements UserAccountService {
	
	private UserAccountDAO userAccountDAO;
	
	public DefaultUserAccountService(EntityManager entityManager) {
		userAccountDAO = new UserAccountDAO(entityManager);
	}

	@Override
	public void create(UserAccount userAccount) {
		userAccountDAO.create(userAccount);
	}

	@Override
	public UserAccount retrieveOne(long id) {
		return userAccountDAO.retrieveOne(id);
	}

	@Override
	public List<UserAccount> retrieveAll() {
		return userAccountDAO.retrieveAll();
	}

	@Override
	public void update(UserAccount userAccount) {
		userAccountDAO.update(userAccount);
	}

	@Override
	public void delete(long id) {
		userAccountDAO.delete(id);
	}

	@Override
	public UserAccount getByUsernameAndPassword(String username, String password) {
		return userAccountDAO.getByUsernameAndPassword(username, password);
	}

}
