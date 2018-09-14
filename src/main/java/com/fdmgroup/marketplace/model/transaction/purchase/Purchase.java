package com.fdmgroup.marketplace.model.transaction.purchase;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

import com.fdmgroup.marketplace.model.transaction.Checkout;
import com.fdmgroup.marketplace.model.user.UserAccount;

@Entity
@NamedQuery(name="Purchase.getAllByUserId", query="SELECT p FROM Purchase p JOIN p.buyer b WHERE b.id = :id")
public class Purchase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="purchase_id_generator" ) 
	@SequenceGenerator(name="purchase_id_generator", sequenceName="PURCHASE_ID_SEQ", initialValue=1, allocationSize=1) 
	private long id;
	@ManyToOne
	private UserAccount buyer;
	@Column
	private LocalDateTime time;
	@ManyToMany
	@JoinColumn(name = "id")
	private List<PurchaseItem> purchaseItems;
	
	public Purchase() {
		this.purchaseItems = new ArrayList<>();
	}

	public Purchase(UserAccount buyer, LocalDateTime time) {
		this.buyer = buyer;
		this.time = time;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	
	public UserAccount getBuyer() {
		return buyer;
	}

	public void setBuyer(UserAccount buyer) {
		this.buyer = buyer;
	}

	public List<PurchaseItem> getPurchaseItems() {
		return purchaseItems;
	}

	public void setPurchaseItems(List<PurchaseItem> purchaseItems) {
		this.purchaseItems = purchaseItems;
	}
	
	public void addToPurchase(PurchaseItem purchaseItem) {
		if (purchaseItem.getItem() != null && purchaseItem.getQuantity() > 0) {
			this.purchaseItems.add(purchaseItem);
		}
	}
	
	public BigDecimal getPrice() {
		return Checkout.calculateTotalCost(this);
	}

}
