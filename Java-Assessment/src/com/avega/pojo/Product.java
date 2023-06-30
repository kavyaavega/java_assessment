package com.avega.pojo;

import java.util.Objects;

public class Product {
	private	 String  productId;

	private String productName;
	
	private double unitPrice;

	private int quantityOnHand;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantityOnHand() {
		return quantityOnHand;
	}

	public void setQuantityOnHand(int quantityOnHand) {
		this.quantityOnHand = quantityOnHand;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", unitPrice=" + unitPrice
				+ ", quantityOnHand=" + quantityOnHand + "]";
	}

	public Product(String productId, String productName, double unitPrice, int quantityOnHand) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.unitPrice = unitPrice;
		this.quantityOnHand = quantityOnHand;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return Objects.hash(productId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(productId, other.productId);
	}
	
	

}
