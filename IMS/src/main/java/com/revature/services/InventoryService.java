package com.revature.services;

import java.util.List;
import com.revature.beans.Item;

public interface InventoryService {
	List<Item> getAllItems();
	Item getItemById(Integer id);
	Item getItemByCriteria();
	
	// Returns no value
	/*void createItem();
	void updateItem();	
	void deleteItem();*/
	
	// Returns value
	Integer createItem(Integer id);
	Integer updateItem(Integer id);	
	Integer deleteItem(Integer id);
}