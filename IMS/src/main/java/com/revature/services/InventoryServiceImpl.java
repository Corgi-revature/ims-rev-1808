package com.revature.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Item;
import com.revature.data.ItemDAO;

@Service
public class InventoryServiceImpl implements InventoryService {
	@Autowired
	// changes required to pan out inventory and item
	private ItemDAO ds;
	
	@Override
	public Item addItem(Item ite) {
		return ite;
	}

	@Override
	public Item getItemById(int id) {

		return null;
	}

	@Override
	public Set<Item> getItems() {

		return null;
	}

	@Override
	public Set<Item> getItemsCriteria() {

		return null;
	}

	@Override
	public void updateItem(Item ite) {
		
	}

	@Override
	public void deleteItem(Item ite) {
		
	}

	@Override
	public void deleteItemById(int id) {

	}
}
