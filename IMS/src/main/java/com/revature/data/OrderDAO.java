package com.revature.data;

import java.util.Set;

import com.revature.beans.Order;

public interface OrderDAO {
	public Order addOrder(Order ord);
	public Order getOrderById(int id);
	public Set<Order> getOrdersCriteria();
	public Set<Order> getOrders();
	public void updateOrder(Order ord);
	public void deleteOrder(Order ord);
	public void deleteOrderById(int id);
}
