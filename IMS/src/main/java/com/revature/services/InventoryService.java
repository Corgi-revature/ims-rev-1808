package com.revature.services;

import java.util.List;
import java.util.Set;

import com.revature.beans.Inventory;

public interface InventoryService {
	int addInventory(Inventory inv);
	Inventory getInventoryById(int id);
	Set<Inventory> getInventory();
	List<Inventory> getInventoryCriteria(Inventory inv);
	void updateInventory(Inventory inv);	
	void deleteInventory(Inventory inv);
	void deleteInventoryById(int id);
}
