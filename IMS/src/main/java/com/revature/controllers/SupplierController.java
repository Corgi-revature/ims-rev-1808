package com.revature.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	Supplier addOrder(Supplier sup) {
		sups.addSupplier(sup);
		return sup;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	Supplier getSupplierByID(Integer id) {
		return sups.getSupplierById(id);
	}
	
	@RequestMapping(value="/all",  method = RequestMethod.GET)
	Set<Supplier> getSuppliers() {
		return sups.getSuppliers();
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	List<Supplier> getSuppliersCriteria() {
		return sups.getSuppliersCriteria();
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	void updateSupplier( Supplier sup) {
		sups.updateSupplier(sup);
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	void deleteSupplier( Supplier sup) {
		sups.deleteSupplier(sup);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	void deleteSupplierById(Integer id) {
		sups.deleteSupplierById(id);
	}
	
}
