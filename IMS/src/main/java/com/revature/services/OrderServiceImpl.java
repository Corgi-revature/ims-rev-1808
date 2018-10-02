package com.revature.services;

import java.util.List;
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
	public int addOrder(Order ord) {
		return ds.addOrder(ord);
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
	public 
	List<Order> getOrdersCriteria(Order ord) {
		return ds.getOrdersCriteria(ord);
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
