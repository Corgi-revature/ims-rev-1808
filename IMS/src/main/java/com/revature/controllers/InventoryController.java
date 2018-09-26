package com.revature.controllers;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.beans.Item;
import com.revature.services.InventoryService;

@Controller
@RequestMapping(value="/Inventory")
@CrossOrigin(origins = "http://localhost:4200")
public class InventoryController {
	@Autowired
	private InventoryService is;
	
	@RequestMapping(value="/item", method=RequestMethod.POST)
	Item addItem(@RequestBody Item ite) {
		is.addItem(ite);
		return ite;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	Item getItemById(int id) {
		return is.getItemById(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	Set<Item> getItems() {
		return is.getItems();
	}

	@RequestMapping(value = "/item", method = RequestMethod.GET)
	Set<Item> getItemsCriteria() {
		return is.getItemsCriteria();
	}

	@RequestMapping(value = "/item", method = RequestMethod.PUT)
	void updateItem(@RequestBody  Item ite) {
		is.updateItem(ite);
	}

	@RequestMapping(value = "/item", method = RequestMethod.DELETE)
	void deleteItem(@RequestBody  Item ite) {
		is.deleteItem(ite);
	}
	
	@RequestMapping(value = "/item", method = RequestMethod.DELETE)
	void deleteItemById(@RequestBody int id) {
		is.deleteItemById(id);
	}
}



