package com.avega.pojo;

import java.sql.Date;
import java.util.Objects;


public class Order implements Comparable<Order> {
	
    private String orderId;
	
	private Customer customer;
	
	private Date orderDate;
	
	private int orderValue;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getOrderValue() {
		return orderValue;
	}

	public void setOrderValue(int orderValue) {
		this.orderValue = orderValue;
	}

	public Order(String orderId, Customer customer, Date orderDate, int orderValue) {
		super();
		this.orderId = orderId;
		this.customer = customer;
		this.orderDate = orderDate;
		this.orderValue = orderValue;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customer=" + customer + ", orderDate=" + orderDate + ", orderValue="
				+ orderValue + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(customer, orderDate, orderId, orderValue);
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(customer, other.customer) && Objects.equals(orderDate, other.orderDate)
				&& Objects.equals(orderId, other.orderId) && orderValue == other.orderValue;
	}

	@Override
	public int compareTo(Order o) {
		return this.orderDate.compareTo(o.orderDate);
	}
	
	

	
	
	
	

}
