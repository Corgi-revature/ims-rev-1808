package com.revature.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Inventory;
import com.revature.data.InventoryDAO;

@Service
public class InventoryServiceImpl implements InventoryService {
	
	@Autowired
	private InventoryDAO ivs;
	
	@Override
	public int addInventory(Inventory inv) {
		int result = ivs.addInventory(inv);
		return result;
	}

	@Override
	public Inventory getInventoryById(int id) {
		return ivs.getInventoryById(id);
	}

	@Override
	public Set<Inventory> getInventory() {
		return ivs.getInventory();
	}

	@Override
	public List<Inventory> getInventoryCriteria(Inventory inv) {
		return ivs.getInventoryCriteria();
	}

	@Override
	public void updateInventory(Inventory inv) {
		ivs.updateInventory(inv);

	}

	@Override
	public void deleteInventory(Inventory inv) {
		ivs.deleteInventory(inv);

	}

	@Override
	public void deleteInventoryById(int id) {
		ivs.deleteInventoryById(id);

	}

}
