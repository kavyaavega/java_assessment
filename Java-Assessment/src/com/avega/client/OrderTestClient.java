package com.avega.client;


import java.sql.Date;
import java.util.Arrays;

import com.avega.pojo.Customer;
import com.avega.pojo.Order;
import com.avega.service.CustomerService;
import com.avega.service.OrderService;
import com.avega.serviceimpl.CustomerServiceImpl;
import com.avega.serviceimpl.OrderServiceImpl;

public class OrderTestClient {

	public static void main(String[] args) {
		OrderService  orderService = new OrderServiceImpl();
		//CustomerService  customerService = new CustomerServiceImpl();
		//customerService.createCustomer(new Customer("CU104","naveen","7th cross jaynagar",15236));
		//System.out.println(orderService.findOrderByOrderId("OR111"));
		
		//System.out.println(orderService.findOrderByCustomerId("CU103"));
		
		//System.out.println(orderService.createOrder(new Order("OR114",null,Date.valueOf("2023-06-28"),1500)));
		
		//System.out.println(orderService.editOrder(new Order("OR114","CU103",Date.valueOf("2023-06-28"),1800)));
				
		//System.out.println(orderService.removeOrder(new Order("OR114","CU103",Date.valueOf("2023-06-28"),1800)));
		
		//sort
		/*Order  orderlist[] = {
				new Order("OR111","CU101",Date.valueOf("2023-06-30"),1000),
				                 new Order("OR112","CU102",Date.valueOf("2023-06-29"),2000),
				                 new Order("OR113","CU103",Date.valueOf("2023-06-28"),3000),
		                         };
		Arrays.sort(orderlist);
		System.out.println(Arrays.toString(orderlist));
	}  */           

	}

}
