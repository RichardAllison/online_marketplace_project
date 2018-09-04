package com.fdmgroup.marketplace.models.users;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fdmgroup.marketplace.models.items.Product;
import com.fdmgroup.marketplace.models.transactions.Transaction;

@Entity
public class UserAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="user_account_generator" ) 
	@SequenceGenerator(name="user_account_generator", sequenceName="USER_ACCOUNT_SEQ", initialValue=1, allocationSize=1) 
	private long id;
	@Column(nullable=false, length=80)
	private String username;
	@Column(length=80)
	private String emailAddress;
	@Column(nullable=false, length=80)
	private String password;

	@OneToMany(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "id")
	private List<Product> products;

	@OneToMany(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "id")
	private List<Transaction> sales;

	@OneToMany(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "id")
	private List<Transaction> purchases;
	
	public UserAccount(String username, String password) {
		this.username = username;
		this.password = password;
		this.products = new ArrayList<Product>();
		this.sales = new ArrayList<Transaction>();
		this.purchases = new ArrayList<Transaction>();
	}

	public UserAccount() {
		this.products = new ArrayList<Product>();
		this.sales = new ArrayList<Transaction>();
		this.purchases = new ArrayList<Transaction>();
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
	
	public List<Transaction> getSales() {
		return sales;
	}

	public void setSales(List<Transaction> sales) {
		this.sales = sales;
	}

	public List<Transaction> getPurchases() {
		return purchases;
	}

	public void setPurchases(List<Transaction> purchases) {
		this.purchases = purchases;
	}
	
	public void addProduct(Product product) {
		this.products.add(product);
	}
	
	public void removeProduct(Product product) {
		this.products.remove(product);
	}
	
	public void addToSales(Transaction sale) {
		this.sales.add(sale);
	}
	
	public void addToPurchases(Transaction purchase) {
		this.purchases.add(purchase);
	}

}
