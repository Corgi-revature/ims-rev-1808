package com.revature.services;

import java.util.Set;
import com.revature.beans.Order;

public interface OrderService {
	Order addOrder(Order ord);
	Order getOrderById(int id);
	Set<Order> getOrders();
	Set<Order> getOrdersCriteria();
	Order updateOrder(Order ord);	
	Order deleteOrder(Order ord);
	Integer deleteOrderById(int id);
}
