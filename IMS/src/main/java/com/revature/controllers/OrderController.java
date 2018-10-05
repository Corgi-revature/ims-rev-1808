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
import com.revature.beans.OrderTotal;
import com.revature.data.OrderTotalDAO;
import com.revature.services.OrderService;

@RestController
@RequestMapping(value="/order")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {
	@Autowired
	private OrderService os;
	@Autowired
	private OrderTotalDAO otd;
	
	@RequestMapping(method=RequestMethod.POST)	
	int addOrder(@RequestBody Order ord) {
		return os.addOrder(ord);
	}
	
	@RequestMapping(value="/txact/{id}", method=RequestMethod.GET)
	Set<Order> getOrdersByTxid(@PathVariable int id){
		return os.getOrdersByTxid(id);
	}
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	Order getOrderByID(@PathVariable int id) {
		return os.getOrderById(id);
	}
	@RequestMapping(value="/all",  method = RequestMethod.GET)
	Set<Order> getOrders() {
		return os.getOrders();
	}
	
	@RequestMapping(value="/total/all",  method = RequestMethod.GET)
	Set<OrderTotal> getAllOrderT() {
		return otd.getOrdTotals();
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	List<Order> getOrdersCriteria(@RequestBody Order ord) {
		return os.getOrdersCriteria(ord);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	void updateOrder(@RequestBody Order ord) {
		os.updateOrder(ord);
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	void deleteOrder(@RequestBody Order ord) {
		os.deleteOrder(ord);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	void deleteOrderById(@PathVariable int id) {
		os.deleteOrderById(id);
	}
}


