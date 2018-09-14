package com.fdmgroup.marketplace.repository.user;

import com.fdmgroup.marketplace.model.user.UserAccount;
import com.fdmgroup.marketplace.repository.CRUD;

public interface UserAccountCRUD extends CRUD<UserAccount> {

	UserAccount getByUsernameAndPassword(String username, String password);
	
}
