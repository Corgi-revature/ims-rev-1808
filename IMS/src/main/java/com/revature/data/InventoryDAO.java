package com.revature.data;

import java.util.List;
import java.util.Set;

import com.revature.beans.Inventory;

public interface InventoryDAO {
	public int addInventory(Inventory inv);
	public Inventory getInventoryById(int id);
	public List<Inventory> getInventoryCriteria();
	public Set<Inventory> getInventory();
	public void updateInventory(Inventory inv);
	public void deleteInventory(Inventory inv);
	public void deleteInventoryById(int id);
}
