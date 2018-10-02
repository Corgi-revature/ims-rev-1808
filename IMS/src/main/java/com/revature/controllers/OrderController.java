package com.revature.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	int addOrder(@RequestBody Order ord) {
		return os.addOrder(ord);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	Order getOrderByID(@PathVariable int id) {
		return os.getOrderById(id);
	}
	@RequestMapping(value="/all",  method = RequestMethod.GET)
	Set<Order> getOrders() {
		return os.getOrders();
	}
	
	/*@RequestMapping(value="/{ord}", method=RequestMethod.GET)
	List<Order> getOrdersCriteria(@PathVariable Order ord) {
		return os.getOrdersCriteria(ord);
	}*/
	
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


