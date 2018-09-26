package com.revature.services;

import java.util.List;
import com.revature.beans.Order;

public interface OrderService {
	List<Order> getOrders();
	Order getOrderById(Integer id);
	Order getOrderCriteria();
	
	// Returns no value
	/*void createOrder();
	void updateOrder();	
	void deleteOrder();*/
	
	// Returns value
	Integer createOrder(Integer id);
	Integer updateOrder(Integer id);	
	Integer deleteOrder(Integer id);
}
