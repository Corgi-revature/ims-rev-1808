package com.revature.controllers;

import java.util.Set;

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

	@RequestMapping(value = "/delivery", method = RequestMethod.POST)
	Delivery addDelivery(@RequestBody Delivery deli) {
		ds.addDelivery(deli);
		return deli;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	Delivery getDeliveryById(int id) {
		return ds.getDeliveryById(id);
	}
	
		@RequestMapping(method = RequestMethod.GET)
	Set<Delivery> getDeliverys(){
		return ds.getDeliverys();
	}
	
	@RequestMapping(value = "/delivery", method = RequestMethod.GET)
	Set<Delivery> getDeliverysCriteria() {
		return ds.getDeliverysCriteria();
	}
	
	@RequestMapping(value = "/delivery", method = RequestMethod.PUT)
	void updateDelivery(@RequestBody Delivery deli) {
		ds.updateDelivery(deli);
	}
	
	@RequestMapping(value = "/delivery", method = RequestMethod.DELETE)
	void deleteDelivery(@RequestBody Delivery deli) {
		ds.deleteDelivery(deli);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	void deleteDeliveryById(@RequestBody Integer id) {
		ds.deleteDeliveryById(id);
	}
}
