package com.fdmgroup.marketplace.repository;

import java.util.List;

public interface CRUD<E> {

	void create(E e);
	E retrieveOne(long id);
	List<E> retrieveAll();
	void update(long id, E e);
	void delete(long id);
}
