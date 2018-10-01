package com.revature.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Order;
import com.revature.data.OrderDAO;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDAO ds;

	@Override
	public Order addOrder(Order ord) {
		ds.addOrder(ord);
		return ord;
	}

	@Override
	public Order getOrderById(int id) {
		return ds.getOrderById(id);
	}

	@Override
	public Set<Order> getOrders() {
		return ds.getOrders();
	}

	@Override
	public Set<Order> getOrdersCriteria() {
		return ds.getOrdersCriteria();
	}

	@Override
	public void updateOrder(Order ord) {
		ds.updateOrder(ord);
	}

	@Override
	public void deleteOrder(Order ord) {
		ds.deleteOrder(ord);
	}

	@Override
	public void deleteOrderById(int id) {
		ds.deleteOrderById(id);
	}

	
}
