package com.fdmgroup.marketplace.repository;

import java.util.List;

public interface CRUD<E> {

	public void create(E e);
	public E retrieveOne(long id);
	public List<E> retrieveAll();
	public void update(E e);
	public void delete(long id);
}
