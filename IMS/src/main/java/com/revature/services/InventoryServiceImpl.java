package com.revature.services;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.revature.beans.Item;
import com.revature.data.ItemDAO;
import com.revature.data.ItemHibernate;

@Service
public class InventoryServiceImpl implements InventoryService {
	private ItemDAO itemDAO = new ItemHibernate();
	
	@Override
	public int addItem(Item ite) {
		int itemID = itemDAO.addItem(ite);
		return itemID;
	}

	@Override
	public Item getItemById(int id) {
<<<<<<< HEAD
		return itemDAO.getItemById(id);
=======

		return null;
>>>>>>> 4634f1dcfc170c7c9f5a2351d509a0ad7f78134c
	}

	@Override
	public Set<Item> getItems() {
<<<<<<< HEAD
		return itemDAO.getItems();
=======

		return null;
>>>>>>> 4634f1dcfc170c7c9f5a2351d509a0ad7f78134c
	}

	@Override
	public Set<Item> getItemsCriteria() {
<<<<<<< HEAD
		return itemDAO.getItemsCriteria();
=======

		return null;
>>>>>>> 4634f1dcfc170c7c9f5a2351d509a0ad7f78134c
	}

	@Override
	public void updateItem(Item ite) {
<<<<<<< HEAD
		itemDAO.updateItem(ite);
=======
		
>>>>>>> 4634f1dcfc170c7c9f5a2351d509a0ad7f78134c
	}

	@Override
	public void deleteItem(Item ite) {
<<<<<<< HEAD
		itemDAO.deleteItem(ite);
=======
		
>>>>>>> 4634f1dcfc170c7c9f5a2351d509a0ad7f78134c
	}

	@Override
	public void deleteItemById(int id) {
<<<<<<< HEAD
		itemDAO.deleteItemById(id);
=======

>>>>>>> 4634f1dcfc170c7c9f5a2351d509a0ad7f78134c
	}
}
