package com.fdmgroup.marketplace.models.users;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fdmgroup.marketplace.models.items.Product;
import com.fdmgroup.marketplace.models.transactions.Order;

@Entity
public class UserAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="user_account_generator" ) 
	@SequenceGenerator(name="user_account_generator", sequenceName="USER_ACCOUNT_SEQ", initialValue=1, allocationSize=1) 
	private long id;
	@Column
	private String username;
	@Column
	private String emailAddress;
	@Column
	private String password;
	@Column
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinColumn(name = "id")
	private List<Product> products;

	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinColumn(name = "id")
	private List<Order> sales;

	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinColumn(name = "id")
	private List<Order> purchases;
	

	public UserAccount() {
		this.products = new ArrayList<Product>();
		this.sales = new ArrayList<Order>();
		this.purchases = new ArrayList<Order>();
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public List<Order> getSales() {
		return sales;
	}

	public void setSales(List<Order> sales) {
		this.sales = sales;
	}

	public List<Order> getPurchases() {
		return purchases;
	}

	public void setPurchases(List<Order> purchases) {
		this.purchases = purchases;
	}
	
	public void addProduct(Product product) {
		this.products.add(product);
	}
	
	public void removeProduct(Product product) {
		this.products.remove(product);
	}
	
	public void addToSales(Order sale) {
		this.sales.add(sale);
	}
	
	public void addToPurchases(Order purchase) {
		this.purchases.add(purchase);
	}

}
