package com.revature.data;

import java.util.Set;

import com.revature.beans.Item;

public interface ItemDAO extends HibernateSession {
	public int addItem(Item ite);
	public Item getItemById(int id);
	public Set<Item> getItemsCriteria();
	public Set<Item> getItems();
	public void updateItem(Item ite);
	public void deleteItem(Item ite);
	public void deleteItemById(int id);
}
