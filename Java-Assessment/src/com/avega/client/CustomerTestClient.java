package com.avega.client;

import com.avega.pojo.Customer;
import com.avega.service.CustomerService;
import com.avega.serviceimpl.CustomerServiceImpl;

public class CustomerTestClient {

	public static void main(String[] args) {
		
		CustomerService  customerService = new CustomerServiceImpl();
		//customerService.findAllcustomers().forEach(customer-> System.out.println(customer));
		
		//System.out.println(customerService.findCustomerByCustomerId("CU101"));
		
		//System.out.println(customerService.createCustomer(new Customer("CU104","naveen","7th cross jaynagar",15236)));
		
		//System.out.println(customerService.editCustomer(new Customer("CU104","naveen bharathy","7th cross jaynagar",15236)));
		
		System.out.println(customerService.removeCustomer(new Customer("CU104","naveen bharathy","7th cross jaynagar",15236)));
		

	}

}
