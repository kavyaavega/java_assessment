package com.avega.serviceimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.avega.dao.CustomerDao;
import com.avega.daoimpl.CustomerDaoImpl;
import com.avega.dbutil.DBUtils;
import com.avega.pojo.Customer;
import com.avega.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	
	static Connection connection = DBUtils.getConnection();
	PreparedStatement ps = null;
	Statement statement = null;
	static Logger logger = Logger.getLogger(CustomerServiceImpl.class.getName());
	
	CustomerDao customerDao = null;
		
		public CustomerServiceImpl() {
			this.customerDao = new CustomerDaoImpl();
		}
		
		List<Customer> customers = new ArrayList<>();

	@Override
	public List<Customer> findAllcustomers() {
		return customerDao.getAllCustomers();
	}

	@Override
	public Customer findCustomerByCustomerId(String customerId) {
		return customerDao.getCustomerByCustomerId(customerId);
	}

	@Override
	public boolean createCustomer(Customer customer) {
		return customerDao.addCustomer(customer);
	}

	@Override
	public boolean removeCustomer(Customer customer) {
		return customerDao.deleteCustomer(customer);
	}

	@Override
	public boolean editCustomer(Customer customer) {
		return customerDao.updateCustomer(customer);
	}

}
