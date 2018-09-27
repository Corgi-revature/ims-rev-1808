package com.revature.data;

import java.util.Set;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.revature.beans.Item;

@Component
public class ItemHibernate implements ItemDAO {
	private Session session;
	@Override
	public void setSession(Session session) {
		this.session = session;
	}
	
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
