package com.revature.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Item;
import com.revature.services.InventoryService;

@RestController
@RequestMapping(value="/inventory")
@CrossOrigin(origins = "http://localhost:4200")
public class InventoryController {
	@Autowired
	private InventoryService is;
	
	@RequestMapping(method=RequestMethod.GET)
	Set<Item> getItems() {
		return is.getItems();
	}
	
	@RequestMapping(value="/{item}", method=RequestMethod.POST)
	Item addItem( Item ite) {
		is.addItem(ite);
		return ite;
	}

	@RequestMapping(value = "/{item}/{id}", method = RequestMethod.GET)
	Item getItemById(int id) {
		return is.getItemById(id);
	}

//	@RequestMapping(value = "/{item}/all",method = RequestMethod.GET)
//	Set<Item> getItems() {
//		return is.getItems();
//	}

	@RequestMapping(value = "/{item}", method = RequestMethod.GET)
	Set<Item> getItemsCriteria() {
		return is.getItemsCriteria();
	}

	@RequestMapping(value = "/{item}", method = RequestMethod.PUT)
	void updateItem( Item ite) {
		is.updateItem(ite);
	}

	@RequestMapping(value = "/{item}", method = RequestMethod.DELETE)
	void deleteItem( Item ite) {
		is.deleteItem(ite);
	}
	
	@RequestMapping(value = "/{item}/{id}", method = RequestMethod.DELETE)
	void deleteItemById( int id) {
		is.deleteItemById(id);
	}
}



