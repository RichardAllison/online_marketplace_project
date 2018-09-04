package com.fdmgroup.marketplace.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.fdmgroup.marketplace.models.users.UserAccount;

public class UserAccountDAO implements CRUD<UserAccount> {
	
	EntityManager entityManager;
	
	public UserAccountDAO(EntityManager entityManager){
		this.entityManager = entityManager;
	}
	
	public void create(UserAccount userAccount) {
		entityManager.persist(userAccount);
	}
	
	public UserAccount getByUsernameAndPassword(String username, String password) throws NoResultException {
		return entityManager.createQuery(
			"select u from WebUser u where u.username = :username and u.password = :password", UserAccount.class)
				.setParameter("username", username)
				.setParameter("password", password)
				.getSingleResult();
	}

	@Override
	public UserAccount retrieveOne(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserAccount> retrieveAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(long id, UserAccount e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

}
