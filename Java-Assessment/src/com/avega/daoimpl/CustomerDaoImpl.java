package com.avega.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.avega.dao.CustomerDao;
import com.avega.dbutil.DBUtils;
import com.avega.pojo.Customer;

public class CustomerDaoImpl implements CustomerDao {
	
	static Logger logger = Logger.getLogger(DBUtils.class.getName());
    Connection connection = DBUtils.getConnection();
    PreparedStatement ps = null;


	@Override
	public List<Customer> getAllCustomers() {
		ResultSet rs = null;
		String query = "SELECT * FROM customers";
		List<Customer> customers = new ArrayList<>();
		
		try {
			ps= connection.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				customers.add(new Customer(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return customers;
	}

	@Override
	public Customer getCustomerByCustomerId(String customerId) {
		ResultSet rs = null;
	    String query = "SELECT * FROM customers WHERE customer_id = ?";
	    
	    try {
	        ps = connection.prepareStatement(query);
	         ps.setString(1, customerId);
	        rs = ps.executeQuery();
	        while (rs.next()) {
	        	Customer customerdb = new Customer();
	        	customerdb.setCustomerId(rs.getString("customer_id"));
	        	customerdb.setCustomerName(rs.getString("customer_name"));
	        	customerdb.setAddress(rs.getString("address"));
	        	customerdb.setContactNo(rs.getInt("contact_no"));
	        	return customerdb;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } 
	    return null;
	}

	@Override
	public boolean addCustomer(Customer customer) {
		boolean isAdded = false;
		String query = "Insert into customers Values(?,?,?,?)";
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, customer.getCustomerId());
			ps.setString(2, customer.getCustomerName());
			ps.setString(3, customer.getAddress());
			ps.setInt(4, customer.getContactNo());
			 int count = ps.executeUpdate();
	            if (count > 0) {
	                logger.info("Customer added successfully!");
	                isAdded = true;
	            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isAdded;
	}

	@Override
	public boolean deleteCustomer(Customer customer) {
		boolean isDeleted = false;
		String query = "Delete from customers WHERE customer_id = ?";
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, customer.getCustomerId());
			int count = ps.executeUpdate();
			if(count > 0) {
				logger.info("Customer deleted successfully");
				isDeleted= true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return isDeleted;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		boolean isUpdate = false;
	    String query = "UPDATE customers SET  customer_name = ?,address = ?,contact_no = ? Where customer_id = ?";
	    try {
			ps = connection.prepareStatement(query);
			ps.setString(1,customer.getCustomerName());
			ps.setString(2, customer.getAddress());
			ps.setInt(3, customer.getContactNo());
			ps.setString(4, customer.getCustomerId());
			
			int count = ps.executeUpdate();
			if(count> 0) {
				logger.info("Customer updated successfully");
				isUpdate= true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	return isUpdate;
	}

}
