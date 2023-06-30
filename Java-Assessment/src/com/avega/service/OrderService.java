package com.avega.service;

import com.avega.pojo.Order;

public interface OrderService {
	
	Order findOrderByOrderId(String orderId) ;
	Order findOrderByCustomerId(String customerId);
	boolean createOrder(Order order);
	boolean removeOrder(Order order);
	boolean editOrder(Order order);

}
