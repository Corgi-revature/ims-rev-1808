package com.revature.services;

import java.util.List;
import com.revature.beans.Order;

public interface OrderService {
	List<Order> getAllOrders();
	Order getOrderById(Integer id);
	Order getOrderByCriteria();
	
	// Returns no value
	/*void createOrder();
	void updateOrder();	
	void deleteOrder();*/
	
	// Returns value
	Integer createOrder(Integer id);
	Integer updateOrder(Integer id);	
	Integer deleteOrder(Integer id);
}
