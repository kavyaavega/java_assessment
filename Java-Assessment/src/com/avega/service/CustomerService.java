package com.avega.service;

import java.util.List;
import com.avega.pojo.Customer;

public interface CustomerService {
	
	List<Customer> findAllcustomers();
	Customer findCustomerByCustomerId(String customerId) ;
	boolean createCustomer(Customer customer);
	boolean removeCustomer(Customer customer);
	boolean editCustomer(Customer customer);

}
