package com.fdmgroup.marketplace.service.user;

import java.util.List;

import javax.persistence.EntityManager;

import com.fdmgroup.marketplace.model.user.UserAccount;
import com.fdmgroup.marketplace.repository.CRUD;
import com.fdmgroup.marketplace.repository.user.UserAccountDAO;

public class DefaultUserAccountService implements UserAccountService {
	
	private CRUD<UserAccount> userAccountCRUD;
	private EntityManager entityManager;
	
	public DefaultUserAccountService(EntityManager entityManager) {
		this.entityManager = entityManager;
		userAccountCRUD = new UserAccountDAO(entityManager);
	}

	@Override
	public void create(UserAccount userAccount) {
		userAccountCRUD.create(userAccount);
	}

	@Override
	public UserAccount retrieveOne(long id) {
		return userAccountCRUD.retrieveOne(id);
	}

	@Override
	public List<UserAccount> retrieveAll() {
		return userAccountCRUD.retrieveAll();
	}

	@Override
	public void update(UserAccount userAccount) {
		userAccountCRUD.update(userAccount);
	}

	@Override
	public void delete(long id) {
		userAccountCRUD.delete(id);
	}

	@Override
	public UserAccount getByUsernameAndPassword(String username, String password) {
		UserAccountDAO userAccountDAO = new UserAccountDAO(entityManager);
		return userAccountDAO.getByUsernameAndPassword(username, password);
	}

}
