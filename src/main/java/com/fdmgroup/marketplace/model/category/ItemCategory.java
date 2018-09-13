package com.fdmgroup.marketplace.model.category;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fdmgroup.marketplace.model.item.Item;

@Entity
public class ItemCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="category_generator" ) 
	@SequenceGenerator(name="category_generator", sequenceName="CATEGORY_ID_SEQ", initialValue=1, allocationSize=1) 
	private long id;
	@Column
	private String name;
	@OneToMany(cascade=CascadeType.PERSIST, fetch = FetchType.EAGER, mappedBy = "category")
	private List<Item> items;
	
	public ItemCategory() {}

	public ItemCategory(String name) {
		this.name = name;
	}
	
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
