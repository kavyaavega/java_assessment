package com.avega.dao;

import java.util.List;
import com.avega.pojo.Customer;

public interface CustomerDao {
	
	List<Customer> getAllCustomers();
	Customer getCustomerByCustomerId(String customerId) ;
	boolean addCustomer(Customer customer);
	boolean deleteCustomer(Customer customer);
	boolean updateCustomer(Customer customer);

}
