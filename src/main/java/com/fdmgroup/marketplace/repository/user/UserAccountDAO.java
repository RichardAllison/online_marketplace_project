package com.fdmgroup.marketplace.repository.user;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.fdmgroup.marketplace.model.user.UserAccount;
import com.fdmgroup.marketplace.repository.CRUD;

public class UserAccountDAO implements CRUD<UserAccount>, UserAccountCRUD {
	
	private EntityManager entityManager;
	
	public UserAccountDAO(EntityManager entityManager){
		this.entityManager = entityManager;
	}

	@Override
	public void create(UserAccount userAccount) {
		entityManager.getTransaction().begin();
		entityManager.persist(userAccount);
		entityManager.getTransaction().commit();
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

	public UserAccount getByUsernameAndPassword(String username, String password) throws NoResultException {
		return entityManager.createNamedQuery(
				"UserAccount.getByUsernameAndPassword", UserAccount.class)
				.setParameter("username", username)
				.setParameter("password", password)
				.getSingleResult();
	}
	
	@Override
	public void update(UserAccount userAccount) {
		entityManager.getTransaction().begin();
		entityManager.merge(userAccount);
		entityManager.getTransaction().commit();
	}

	@Override
	public void delete(long id) {
		UserAccount userAccount = entityManager.find(UserAccount.class, id);
		entityManager.getTransaction().begin();
		entityManager.remove(userAccount);
		entityManager.getTransaction().commit();
	}
	
}
