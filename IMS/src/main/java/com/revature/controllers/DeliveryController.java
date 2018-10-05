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

import com.revature.beans.Delivery;
import com.revature.services.DeliveryService;

@RestController
@RequestMapping(value="/delivery")
@CrossOrigin(origins = "http://localhost:4200")
public class DeliveryController {
	@Autowired
	private DeliveryService ds;

	@RequestMapping(method = RequestMethod.POST)
	int addDelivery(@RequestBody Delivery deli) {
		return ds.addDelivery(deli);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	Delivery getDeliveryById(@PathVariable int id) {
		return ds.getDeliveryById(id);
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	Set<Delivery> getDeliveries(){
		return ds.getDeliveries();
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	List<Delivery> getDeliveriesCriteria(@RequestBody Delivery deli) {
		return ds.getDeliveriesCriteria(deli);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	void updateDelivery(@RequestBody Delivery deli) {
		ds.updateDelivery(deli);			
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	void deleteDelivery(@RequestBody Delivery deli) {	
		ds.deleteDelivery(deli);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	void deleteDeliveryById(@PathVariable Integer id) {
		ds.deleteDeliveryById(id);
	}
}
