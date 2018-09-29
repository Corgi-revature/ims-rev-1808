package com.revature.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Delivery;
import com.revature.services.DeliveryService;

@RestController
@RequestMapping(value="/delivery")
@CrossOrigin(origins = "http://localhost:4200")
public class DeliveryController {
	@Autowired
	private DeliveryService ds;

	@RequestMapping(method = RequestMethod.POST)
	Delivery addDelivery(Delivery deli) {
		ds.addDelivery(deli);
		return deli;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	Delivery getDeliveryById(int id) {
		return ds.getDeliveryById(id);
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	Set<Delivery> getDeliveries(){
		return ds.getDeliveries();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	Set<Delivery> getDeliveriesCriteria() {
		return ds.getDeliveriesCriteria();
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	void updateDelivery(Delivery deli) {
		ds.updateDelivery(deli);			
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	void deleteDelivery(Delivery deli) {	
		ds.deleteDelivery(deli);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	void deleteDeliveryById(Integer id) {
		ds.deleteDeliveryById(id);
	}
}
