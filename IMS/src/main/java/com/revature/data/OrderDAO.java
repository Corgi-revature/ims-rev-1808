package com.revature.data;

import java.util.List;
import java.util.Set;

import com.revature.beans.Order;

public interface OrderDAO{
	public int addOrder(Order ord);
	public Order getOrderById(int id);
	public List<Order> getOrdersCriteria(Order ord);
	public Set<Order> getOrders();
	public void updateOrder(Order ord);
	public void deleteOrder(Order ord);
	public void deleteOrderById(int id);
	public Set<Order> getOrdersByTxid(int txid);
}
