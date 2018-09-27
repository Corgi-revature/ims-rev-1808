package com.revature.data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.query.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

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
	public int addItem(Item ite) {
		return (int) session.save(ite);
	}

	@Override
	public Item getItemById(int id) {
		return session.get(Item.class, id);
	}

	@Override
	public Set<Item> getItemsCriteria() {
		CriteriaBuilder build = session.getCriteriaBuilder();
		CriteriaQuery<Item> crit = build.createQuery(Item.class);
		Root<Item> root = crit.from(Item.class);
		crit.select(root);
		List<Item> items = session.createQuery(crit).getResultList();
		return new HashSet<Item>(items);
	}

	@Override
	public Set<Item> getItems() {
		String hql = "FROM com.revature.beans.Item";
		Query<Item> que = session.createQuery(hql, Item.class);
		List<Item> itemList = que.getResultList();
		session.close();
		return new HashSet<Item>(itemList);
	}

	@Override
	public void updateItem(Item ite) {
		Transaction tx = session.beginTransaction();
		try {
			session.update(ite);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteItem(Item ite) {
		Transaction tx = session.beginTransaction();
		try {
			session.delete(ite);
		} catch (Exception e) {
			tx.rollback();
		}
	}

	@Override
	public void deleteItemById(int id) {
		Transaction tx = session.beginTransaction();
		try {
			Item ite = getItemById(id);
			session.delete(ite);
		} catch (Exception e) {
			tx.rollback();
		}
	}

}
