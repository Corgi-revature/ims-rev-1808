package com.revature.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Inventory;
import com.revature.services.InventoryService;

@RestController
@RequestMapping(value="/inventory")
@CrossOrigin(origins = "http://localhost:4200")
public class InventoryController {
	@Autowired
	private InventoryService is;
	
//	@RequestMapping(method=RequestMethod.GET)
//	Set<Item> getItems() {
//		return is.getItems();
//	}
//	
//	@RequestMapping(value="/{item}", method=RequestMethod.POST)
//	Item addItem( Item ite) {
//		is.addItem(ite);
//		return ite;
//	}
	
	@RequestMapping(value="/{inventory}", method=RequestMethod.POST)
	public int addInventory(Inventory inv) {
		int result = is.addInventory(inv);
		return result;
	}

	@RequestMapping(value = "/{inventory}/{id}", method = RequestMethod.GET)
	Inventory getItemById(int id) {
		return is.getInventoryById(id);
	}

//	@RequestMapping(value = "/{item}/all",method = RequestMethod.GET)
//	Set<Item> getItems() {
//		return is.getItems();
//	}

	@RequestMapping(value = "/{inventory}/all",method = RequestMethod.GET)
	Set<Inventory> getItems() {
		return is.getInventory();
	}

	@RequestMapping(value = "/{inventory}", method = RequestMethod.GET)
	List<Inventory> getItemsCriteria() {
		return is.getInventoryCriteria();
	}

	@RequestMapping(value = "/{inventory}", method = RequestMethod.PUT)
	void updateItem(Inventory inv) {
		is.updateInventory(inv);
	}

	@RequestMapping(value = "/{inventory}", method = RequestMethod.DELETE)
	void deleteItem(Inventory inv) {
		is.deleteInventory(inv);
	}
	
	@RequestMapping(value = "/{inventory}/{id}", method = RequestMethod.DELETE)
	void deleteItemById( int id) {
		is.deleteInventoryById(id);
	}
}
