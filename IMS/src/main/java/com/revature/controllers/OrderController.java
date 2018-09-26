package com.revature.controllers;

import java.util.List;

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
	
	@RequestMapping(method = RequestMethod.GET)
	List<Order> getOrders() {
		return os.getOrders();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	Order getOrderByID(Integer id) {
		return os.getOrderById(id);
	}
	
	@RequestMapping(value="/order", method=RequestMethod.GET)
	Order getOrderCriteria() {
		return os.getOrderCriteria();
	}
	
	@RequestMapping(value="/order", method=RequestMethod.POST)	
	Integer createOrder(@RequestBody Integer id) {
		os.createOrder(id);
		return id;
	}
	
	@RequestMapping(value="/order", method=RequestMethod.PUT)
	void updateOrder(@RequestBody Integer id) {
		os.updateOrder(id);
	}
	
	@RequestMapping(value="/order", method=RequestMethod.DELETE)
	void deleteOrder(@RequestBody Integer id) {
		os.deleteOrder(id);
	}
}


