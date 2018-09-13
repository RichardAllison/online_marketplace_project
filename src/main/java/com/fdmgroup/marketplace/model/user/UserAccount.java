package com.fdmgroup.marketplace.model.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fdmgroup.marketplace.model.item.Item;
import com.fdmgroup.marketplace.model.transaction.purchase.Purchase;
import com.fdmgroup.marketplace.model.transaction.sale.Sale;

@Entity(name = "UserAccount")
@NamedQuery(name="UserAccount.getByUsernameAndPassword",
                query="select u from UserAccount u where u.username = :username and u.password = :password")
public class UserAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="user_account_generator" ) 
	@SequenceGenerator(name="user_account_generator", sequenceName="USER_ACCOUNT_ID_SEQ", initialValue=1, allocationSize=1) 
	private long id;
	@Column(nullable=false, length=80, unique=true)
	private String username;
	@Column(length=80, unique=true)
	private String emailAddress;
	@Column(nullable=false, length=80)
	private String password;

	@OneToMany(cascade=CascadeType.PERSIST, fetch = FetchType.EAGER, mappedBy = "seller")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Item> products;

	@OneToMany(cascade=CascadeType.PERSIST, fetch = FetchType.EAGER, mappedBy = "seller")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Sale> sales;

	@OneToMany(cascade=CascadeType.PERSIST, fetch = FetchType.EAGER, mappedBy = "buyer")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Purchase> purchases;
	
	public UserAccount() {
		this.products = new ArrayList<Item>();
		this.sales = new ArrayList<Sale>();
		this.purchases = new ArrayList<Purchase>();
	}
	
	public UserAccount(String username, String password) {
		this();
		this.username = username;
		this.password = password;
	}
	
	public UserAccount(String username, String password, String email) {
		this(username, password);
		this.emailAddress = email;
		
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

	public List<Item> getProducts() {
		return products;
	}

	public void setProducts(List<Item> products) {
		this.products = products;
	}
	
	public List<Sale> getSales() {
		return sales;
	}

	public void setSales(List<Sale> sales) {
		this.sales = sales;
	}

	public List<Purchase> getPurchases() {
		return purchases;
	}

	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}
	
	public void addItem(Item item) {
		this.products.add(item);
	}
	
	public void removeItem(Item item) {
		this.products.remove(item);
	}
	
	public void addToSales(Sale sale) {
		this.sales.add(sale);
	}
	
	public void addToPurchases(Purchase purchase) {
		this.purchases.add(purchase);
	}

}
