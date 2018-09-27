package com.revature.data;

import java.util.Set;

import com.revature.beans.Item;

public interface ItemDAO extends HibernateSession {
<<<<<<< HEAD
	public Item addItem(Item ite);
=======
	public int addItem(Item ite);
>>>>>>> 9e67316221ca644f9f6176b9c1d2f56a4eb11ba7
	public Item getItemById(int id);
	public Set<Item> getItemsCriteria();
	public Set<Item> getItems();
	public void updateItem(Item ite);
	public void deleteItem(Item ite);
	public void deleteItemById(int id);
}
