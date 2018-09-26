package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.beans.Delivery;
import com.revature.services.DeliveryService;

@Controller
@RequestMapping(value="/Delivery")
@CrossOrigin(origins = "http://localhost:4200")
public class DeliveryController {
	@Autowired
	private DeliveryService ds;

	@RequestMapping(method = RequestMethod.GET)
	List<Delivery> getDeliveries(){
		return ds.getDeliveries();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	Delivery getDeliveryById(Integer id) {
		return ds.getDeliveryById(id);
	}
	
	@RequestMapping(value = "/Delivery", method = RequestMethod.GET)
	Delivery getDeliveryCriteria() {
		return ds.getDeliveryCriteria();
	}
	
	@RequestMapping(value = "/Delivery", method = RequestMethod.POST)
	Integer createDelivery(@RequestBody Integer id) {
		ds.createDelivery(id);
		return id;
	}
	@RequestMapping(value = "/Delivery", method = RequestMethod.PUT)
	void updateDelivery(@RequestBody Integer id) {
		ds.updateDelivery(id);
	}
	
	@RequestMapping(value = "/Delivery", method = RequestMethod.DELETE)
	void deleteDelivery(@RequestBody Integer id) {
		ds.deleteDelivery(id);
	}
}
