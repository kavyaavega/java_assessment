package com.avega.pojo;

import java.util.Objects;

public class OrderedProducts {
	
	public Order order;
	
	public Product product;
	
	private int quantity;
	
	private double price;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public OrderedProducts(Order order, Product product, int quantity, double price) {
		super();
		this.order = order;
		this.product = product;
		this.quantity = quantity;
		this.price = price;
	}

	public OrderedProducts() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "OrderedProducts [order=" + order + ", product=" + product + ", quantity=" + quantity + ", price="
				+ price + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(order, price, product, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderedProducts other = (OrderedProducts) obj;
		return Objects.equals(order, other.order)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(product, other.product) && quantity == other.quantity;
	}	

}
