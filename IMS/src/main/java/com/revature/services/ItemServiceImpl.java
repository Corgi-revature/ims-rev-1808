package com.revature.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Item;
import com.revature.data.ItemDAO;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemDAO itemDAO;

	@Override
	public int addItem(Item ite) {
		int itemID = itemDAO.addItem(ite);
		return itemID;
	}

	@Override
	public Item getItemById(int id) {
		return itemDAO.getItemById(id);
	}

	@Override
	public Set<Item> getItems() {
		return itemDAO.getItems();
	}

	@Override
	public Set<Item> getItemsCriteria() {
		return itemDAO.getItemsCriteria();
	}

	@Override
	public void updateItem(Item ite) {
		itemDAO.updateItem(ite);
	}

	@Override
	public void deleteItem(Item ite) {
		itemDAO.deleteItem(ite);
	}

	@Override
	public void deleteItemById(int id) {
		itemDAO.deleteItemById(id);
	}
}
