package com.avega.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import com.avega.dao.OrderDao;
import com.avega.dbutil.DBUtils;
import com.avega.pojo.Customer;
import com.avega.pojo.Order;

public class OrderDaoImpl implements OrderDao {
	
	static Logger logger = Logger.getLogger(DBUtils.class.getName());
    Connection connection = DBUtils.getConnection();
    PreparedStatement ps = null;

	@Override
	public Order getOrderByOrderId(String orderId) {
		ResultSet rs = null;
	    String query = "SELECT * FROM orders WHERE order_id = ?";
	    
	    try {
	        ps = connection.prepareStatement(query);
	         ps.setString(1, orderId);
	        rs = ps.executeQuery();
	        while (rs.next()) {
	        	Order orderdb = new Order();
	        	Customer customerdb = new Customer();
	        	orderdb.setOrderId(rs.getString("order_id"));
	        	customerdb.setCustomerId(rs.getString("customer_id"));
	        	orderdb.setOrderDate(rs.getDate("order_date"));
	        	orderdb.setOrderValue(rs.getInt("order_value"));
	        	return orderdb;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } 
	    return null;
	}

	@Override
	public boolean addOrder(Order order) {
		boolean isAdded = false;
		String query = "Insert into orders Values(?,?,?,?)";
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, order.getOrderId());
			ps.setString(2, order.getCustomer().getCustomerId());
			ps.setDate(3, order.getOrderDate());
			ps.setInt(4, order.getOrderValue());
			 int count = ps.executeUpdate();
	            if (count > 0) {
	                logger.info("Orders added successfully!");
	                isAdded = true;
	            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isAdded;
	}

	@Override
	public boolean deleteOrder(Order order) {
		boolean isDeleted = false;
		String query = "Delete from orders WHERE order_id = ?";
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, order.getOrderId());
			int count = ps.executeUpdate();
			if(count > 0) {
				logger.info("Order deleted successfully");
				isDeleted= true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return isDeleted;
	}

	@Override
	public boolean updateOrder(Order order) {
		boolean isUpdate = false;
	    String query = "UPDATE orders SET  customer_id = ?,order_date = ?,order_value = ? Where order_id = ?";
	    try {
			ps = connection.prepareStatement(query);
			ps.setString(1,order.getCustomer().getCustomerId());
			ps.setDate(2, order.getOrderDate());
			ps.setInt(3, order.getOrderValue());
			ps.setString(4, order.getOrderId());
			
			int count = ps.executeUpdate();
			if(count> 0) {
				logger.info("Order updated successfully");
				isUpdate= true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	return isUpdate;
	}

	@Override
	public Order getOrderByCustomerId(String customerId) {
		ResultSet rs = null;
	    String query = "SELECT * FROM orders WHERE customer_id = ?";
	    
	    try {
	        ps = connection.prepareStatement(query);
	         ps.setString(1, customerId);
	        rs = ps.executeQuery();
	        while (rs.next()) {
	        	Order orderdb = new Order();
	        	Customer customerdb = new Customer();
	        	orderdb.setOrderId(rs.getString("order_id"));
	        	customerdb.setCustomerId(rs.getString("customer_id"));
	        	orderdb.setOrderDate(rs.getDate("order_date"));
	        	orderdb.setOrderValue(rs.getInt("order_value"));
	        	return orderdb;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } 
	    return null;	}

	

}
