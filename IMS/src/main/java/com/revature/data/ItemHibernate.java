package com.revature.data;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.Item;
import com.revature.utils.HibernateUtil;

@Component
public class ItemHibernate implements ItemDAO {
	@Autowired
	private HibernateUtil hu;
	
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
	public Set<Item> getItemsCriteria() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Item> getItems() {
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
