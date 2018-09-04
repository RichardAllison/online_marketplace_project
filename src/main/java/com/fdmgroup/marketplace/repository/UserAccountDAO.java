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
	
	public UserAccount getByUsernameAndPassword(String username, String password) throws NoResultException {
		return entityManager.createQuery(
			"select u from WebUser u where u.username = :username and u.password = :password", UserAccount.class)
				.setParameter("username", username)
				.setParameter("password", password)
				.getSingleResult();
	}

	@Override
	public void create(UserAccount userAccount) {
		entityManager.persist(userAccount);
	}

	@Override
	public UserAccount retrieveOne(long id) {
		return entityManager.find(UserAccount.class, id);
	}

	@Override
	public List<UserAccount> retrieveAll() {
		return entityManager.createQuery(
				"select a from UserAccount a", UserAccount.class).getResultList();
	}

	@Override
	public void update(long id, UserAccount userAccount) {
		entityManager.merge(userAccount);
	}

	@Override
	public void delete(long id) {
		UserAccount userAccount = entityManager.find(UserAccount.class, id);
		entityManager.remove(userAccount);
	}


}
