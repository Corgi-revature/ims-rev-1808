package com.revature.controllers;

import java.util.List;

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

	@RequestMapping(method = RequestMethod.GET)
	List<Item> getItems() {
		return is.getItems();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	Item getItemById(Integer id) {
		return is.getItemById(id);
	}

	@RequestMapping(value = "/item", method = RequestMethod.GET)
	Item getItemCriteria() {
		return is.getItemCriteria();
	}

	@RequestMapping(value="/item", method=RequestMethod.POST)
	Integer createItem(@RequestBody Integer id) {
		is.createItem(id);
		return id;
	}

	@RequestMapping(value = "/item", method = RequestMethod.PUT)
	void updateItem(@RequestBody Integer id) {
		is.updateItem(id);
	}

	@RequestMapping(value = "/item", method = RequestMethod.DELETE)
	void deleteItem(@RequestBody Integer id) {
		is.deleteItem(id);
	}
	
}



