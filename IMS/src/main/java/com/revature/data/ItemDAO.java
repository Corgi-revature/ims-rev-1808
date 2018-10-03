package com.revature.data;

import java.util.List;
import java.util.Set;

import com.revature.beans.Item;

public interface ItemDAO {
	public int addItem(Item ite);
	public Item getItemById(int id);
	public List<Item> getItemsCriteria(Item ite);
	public Set<Item> getItems();
	public void updateItem(Item ite);
	public void deleteItem(Item ite);
	public void deleteItemById(int id);
}
