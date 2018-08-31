package com.fdmgroup.marketplace.models.categories;

public class Category {
	
	private long categoryId;
	private String name;
	
	public long getId() {
		return categoryId;
	}
	public void setId(long categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
