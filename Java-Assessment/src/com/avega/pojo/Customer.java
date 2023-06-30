package com.avega.pojo;

import java.util.Objects;

public class Customer {
	
	private String customerId;
	
	private String customerName;
	
	private String address;
	
	private int contactNo;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getContactNo() {
		return contactNo;
	}

	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Customer(String customerId, String customerName, String address, int contactNo) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.address = address;
		this.contactNo = contactNo;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", address=" + address
				+ ", contactNo=" + contactNo + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(customerId, other.customerId);
	}
	
}
