package com.fdmgroup.marketplace.model.transaction.sale;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fdmgroup.marketplace.model.transaction.Checkout;
import com.fdmgroup.marketplace.model.user.UserAccount;

@Entity
@NamedQuery(name="Sale.getAllByUserId", query="SELECT s FROM Sale s JOIN s.seller u WHERE u.id = :id")
public class Sale {
	

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="sale_generator" ) 
	@SequenceGenerator(name="sale_generator", sequenceName="SALE_ID_SEQ", initialValue=1, allocationSize=1) 
	private long id;
	@ManyToOne
	private UserAccount buyer;
	@ManyToOne
	private UserAccount seller;
	@Column
	private Date time;
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, mappedBy = "sale")
	private List<SaleItem> saleItems;
	
	public Sale() {
		this.saleItems = new ArrayList<>();
	}

	public Sale(UserAccount seller, UserAccount buyer, Date time) {
		this();
		this.seller = seller;
		this.buyer = buyer;
		this.time = time;
	}

	public void addToSale(SaleItem saleItem) {
		if (saleItem.getItem() != null && saleItem.getQuantity() > 0) {
			this.saleItems.add(saleItem);
			// increment quantity reserved in product
		}
	}
	
	public UserAccount getBuyer() {
		return buyer;
	}
	
	public long getId() {
		return id;
	}

	public BigDecimal getPrice() {
		return Checkout.calculateTotalCost(this);
	}
	
	public List<SaleItem> getSaleItems() {
		return saleItems;
	}

	public UserAccount getSeller() {
		return seller;
	}

	public Date getTime() {
		return time;
	}

	public void setBuyer(UserAccount buyer) {
		this.buyer = buyer;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public void setSaleItems(List<SaleItem> saleItems) {
		this.saleItems = saleItems;
	}

	public void setSeller(UserAccount seller) {
		this.seller = seller;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Sale [id=");
		builder.append(id);
		builder.append(", buyer=");
		builder.append(buyer);
		builder.append(", seller=");
		builder.append(seller);
		builder.append(", time=");
		builder.append(time);
		builder.append(", saleItems=");
		builder.append(saleItems);
		builder.append("]");
		return builder.toString();
	}

}
