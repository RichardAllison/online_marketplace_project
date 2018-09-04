package com.fdmgroup.marketplace.models.transactions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import com.fdmgroup.marketplace.models.users.UserAccount;

@Entity
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="order_generator" ) 
	@SequenceGenerator(name="order_generator", sequenceName="ORDER_ID_SEQ", initialValue=1, allocationSize=1) 
	private long id;
	@Column
	private UserAccount buyer;
	@Column
	private Date time;
	@ManyToMany
	@JoinColumn(name = "id")
	private List<OrderItem> orderItems;
	
	public Order() {
		this.orderItems = new ArrayList<>();
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	public UserAccount getBuyer() {
		return buyer;
	}

	public void setBuyer(UserAccount buyer) {
		this.buyer = buyer;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	public void addToOrder(OrderItem orderItem) {
		if (orderItem.getItem() != null && orderItem.getQuantity() > 0) {
			this.orderItems.add(orderItem);
			// increment quantity reserved in product
		}
	}

}
