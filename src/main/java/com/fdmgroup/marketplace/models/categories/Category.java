package com.fdmgroup.marketplace.models.categories;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="category_generator" ) 
	@SequenceGenerator(name="category_generator", sequenceName="CATEGORY_ID_SEQ", initialValue=1, allocationSize=1) 
	private long id;
	private String name;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
