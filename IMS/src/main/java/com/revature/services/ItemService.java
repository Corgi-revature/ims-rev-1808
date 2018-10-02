package com.revature.services;

import java.util.List;
import java.util.Set;
import com.revature.beans.Item;

public interface ItemService {
	int addItem(Item ite);
	Item getItemById(int id);
	Set<Item> getItems();
	List<Item> getItemsCriteria(Item ite);
	void updateItem(Item ite);	
	void deleteItem(Item ite);
	void deleteItemById(int id);
}