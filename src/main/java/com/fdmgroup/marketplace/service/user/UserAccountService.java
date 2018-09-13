package com.fdmgroup.marketplace.service.user;

import java.util.List;

import com.fdmgroup.marketplace.model.user.UserAccount;

public interface UserAccountService {
	
	public void create(UserAccount userAccount);
	public UserAccount retrieveOne(long id);
	public List<UserAccount> retrieveAll();
	public UserAccount getByUsernameAndPassword(String username, String password);
	public void update(UserAccount userAccount);
	public void delete(long id);
	
}
