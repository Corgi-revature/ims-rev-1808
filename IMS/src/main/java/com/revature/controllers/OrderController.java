package com.revature.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.beans.Order;
import com.revature.services.OrderService;

@Controller
@RequestMapping(value="/Order")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {
	@Autowired
	private OrderService os;
	
	@RequestMapping(value="/order", method=RequestMethod.POST)	
	Order addOrder(@RequestBody Order ord) {
		os.addOrder(ord);
		return ord;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	Order getOrderByID(Integer id) {
		return os.getOrderById(id);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	Set<Order> getOrders() {
		return os.getOrders();
	}
	
	@RequestMapping(value="/order", method=RequestMethod.GET)
	Set<Order> getOrdersCriteria() {
		return os.getOrdersCriteria();
	}
	
	@RequestMapping(value="/order", method=RequestMethod.PUT)
	void updateOrder(@RequestBody Order ord) {
		os.updateOrder(ord);
	}
	
	@RequestMapping(value="/order", method=RequestMethod.DELETE)
	void deleteOrder(@RequestBody Order ord) {
		os.deleteOrder(ord);
	}
	
	@RequestMapping(value="/order", method=RequestMethod.DELETE)
	void deleteOrderById(@RequestBody Integer id) {
		os.deleteOrderById(id);
	}
}


