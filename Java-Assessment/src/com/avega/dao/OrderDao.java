package com.avega.dao;


import com.avega.pojo.Customer;
import com.avega.pojo.Order;

public interface OrderDao {
	Order getOrderByOrderId(String orderId);
	Order getOrderByCustomerId(String customerId);
	boolean addOrder(Order order);
	boolean deleteOrder(Order order);
	boolean updateOrder(Order order);

}
