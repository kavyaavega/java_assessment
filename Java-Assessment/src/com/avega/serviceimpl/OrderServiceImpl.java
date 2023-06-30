package com.avega.serviceimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


import com.avega.dao.OrderDao;
import com.avega.daoimpl.OrderDaoImpl;
import com.avega.dbutil.DBUtils;
import com.avega.pojo.Order;
import com.avega.service.OrderService;

public class OrderServiceImpl implements OrderService {
	
	static Connection connection = DBUtils.getConnection();
	PreparedStatement ps = null;
	Statement statement = null;
	static Logger logger = Logger.getLogger(OrderServiceImpl.class.getName());
	
	
	OrderDao orderDao = null;
	
	public OrderServiceImpl() {
		this.orderDao = new OrderDaoImpl();
	}
	
	List<Order> orders = new ArrayList<>();
	

	@Override
	public Order findOrderByOrderId(String orderId) {
		return orderDao.getOrderByOrderId(orderId);
	}

	@Override
	public boolean createOrder(Order order) {	
		return orderDao.addOrder(order);
	}

	@Override
	public boolean removeOrder(Order order) {
		return orderDao.deleteOrder(order);
	}

	@Override
	public boolean editOrder(Order order) {
		return orderDao.updateOrder(order);
	}

	@Override
	public Order findOrderByCustomerId(String customerId) {
		return orderDao.getOrderByCustomerId(customerId);
	}

}
