package com.revature.services;

import java.util.List;
import java.util.Set;
import com.revature.beans.Order;

public interface OrderService {
	public int addOrder(Order ord);
	public Order getOrderById(int id);
	Set<Order> getOrders();
	List<Order> getOrdersCriteria(Order ord);
	public void updateOrder(Order ord);	
	public void deleteOrder(Order ord);
	public void deleteOrderById(int id);
}
