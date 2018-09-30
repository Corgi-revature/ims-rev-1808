package com.revature.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Order;
import com.revature.services.OrderService;

@RestController
@RequestMapping(value="/order")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {
	@Autowired
	private OrderService os;
	
	@RequestMapping(method=RequestMethod.POST)	
	Order addOrder(Order ord) {
		os.addOrder(ord);
		return ord;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	Order getOrderByID(Integer id) {
		return os.getOrderById(id);
	}
	// user id then get all their orders?
	@RequestMapping(method = RequestMethod.GET)
	Set<Order> getOrders() {
		return os.getOrders();
	}
	
	@RequestMapping(value="/{uid}/all", method=RequestMethod.GET)
	Set<Order> getOrdersCriteria() {
		return os.getOrdersCriteria();
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	void updateOrder( Order ord) {
		os.updateOrder(ord);
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	void deleteOrder( Order ord) {
		os.deleteOrder(ord);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	void deleteOrderById(Integer id) {
		os.deleteOrderById(id);
	}
}


