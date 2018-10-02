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

import com.revature.beans.Item;
import com.revature.services.ItemService;

@RestController
@RequestMapping(value = "/item")
@CrossOrigin(origins = "http://localhost:4200")
public class ItemController {
	@Autowired
	private ItemService is;

	@RequestMapping(method = RequestMethod.POST)
	Item addItem(@RequestBody Item ite) {
		is.addItem(ite);
		return ite;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	Item getItemById(@PathVariable int id) {
		return is.getItemById(id);
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	Set<Item> getItems() {
		return is.getItems();
	}

	/*@RequestMapping(value = "/{item}", method = RequestMethod.GET)
	List<Item> getItemsCriteria(@PathVariable Item ite) {
		return is.getItemsCriteria(ite);
	}*/

	@RequestMapping(value = "/{item}", method = RequestMethod.PUT)
	void updateItem(@RequestBody Item ite) {
		is.updateItem(ite);
	}

	@RequestMapping(value = "/{item}", method = RequestMethod.DELETE)
	void deleteItem(@RequestBody Item ite) {
		is.deleteItem(ite);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	void deleteItemById(int id) {
		is.deleteItemById(id);
	}
}
