package com.fdmgroup.marketplace.service.user;

import java.util.List;

import com.fdmgroup.marketplace.model.user.UserAccount;
import com.fdmgroup.marketplace.repository.user.UserAccountCRUD;

public class DefaultUserAccountService implements UserAccountService {
	
	private UserAccountCRUD userAccountCRUD;
	
	public DefaultUserAccountService(UserAccountCRUD userAccountCRUD) {
		this.userAccountCRUD = userAccountCRUD;
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
		return userAccountCRUD.getByUsernameAndPassword(username, password);
	}

}
