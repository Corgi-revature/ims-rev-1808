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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order getOrderById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Order> getOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Order> getOrdersCriteria() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order updateOrder(Order ord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order deleteOrder(Order ord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteOrderById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
