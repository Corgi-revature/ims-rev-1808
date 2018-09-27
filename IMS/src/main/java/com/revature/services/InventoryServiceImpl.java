package com.revature.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Item;
import com.revature.data.ItemDAO;

@Service
public class InventoryServiceImpl implements InventoryService {
	@Autowired
//	private InventoryDAO ds;
	private ItemDAO is;

	@Override
	public Item addItem(Item ite) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item getItemById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Item> getItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Item> getItemsCriteria() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateItem(Item ite) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteItem(Item ite) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteItemById(int id) {
		// TODO Auto-generated method stub
		
	}

	
}
