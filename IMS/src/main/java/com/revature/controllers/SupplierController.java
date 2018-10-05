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

import com.revature.beans.Supplier;
import com.revature.services.SupplierService;

@RestController
@RequestMapping(value="/supplier")
@CrossOrigin(origins = "http://localhost:4200")
public class SupplierController {

	@Autowired
	SupplierService sups;
	
	@RequestMapping(method=RequestMethod.POST)	
	int addSupplier(@RequestBody Supplier sup) {
		return sups.addSupplier(sup);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	Supplier getSupplierByID(@PathVariable int id) {
		return sups.getSupplierById(id);
	}
	
	@RequestMapping(value="/all",  method = RequestMethod.GET)
	Set<Supplier> getSuppliers() {
		return sups.getSuppliers();
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	List<Supplier> getSuppliersCriteria(@RequestBody Supplier sup) {
		return sups.getSuppliersCriteria(sup);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	void updateSupplier(@RequestBody Supplier sup) {
		sups.updateSupplier(sup);
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	void deleteSupplier(@RequestBody Supplier sup) {
		sups.deleteSupplier(sup);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	void deleteSupplierById(@PathVariable int id) {
		sups.deleteSupplierById(id);
	}
	
}
