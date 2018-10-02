package com.revature.data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.Item;
import com.revature.utils.HibernateUtil;

@Component
public class ItemHibernate implements ItemDAO {
	@Autowired
	private HibernateUtil hu;
	
	@Override
	public int addItem(Item ite) {
		int sa = 0;
		Session ss = hu.getSession();
		Transaction tx = ss.beginTransaction();
		try {
			sa = (int)ss.save(ite);
			tx.commit();
			return sa;
		} catch (Exception e) {
			tx.rollback();
		} finally {
		}
		return sa;
	}

	@Override
	public Item getItemById(int id) {
		Session ss = hu.getSession();
		return ss.get(Item.class, id);
	}

	@Override
	public List<Item> getItemsCriteria(Item ite) {
		Session ss = hu.getSession();
		CriteriaBuilder build = ss.getCriteriaBuilder();
		CriteriaQuery<Item> crit = build.createQuery(Item.class);
		Root<Item> root = crit.from(Item.class);
		crit.select(root);
		List<Item> items = ss.createQuery(crit).getResultList();
		return new ArrayList<Item>(items);
	}

	@Override
	public Set<Item> getItems() {
		Session ss = hu.getSession();
		String hql = "FROM com.revature.beans.Item";
		Query<Item> que = ss.createQuery(hql, Item.class);
		List<Item> itemList = que.getResultList();
		return new HashSet<Item>(itemList);
	}

	@Override
	public void updateItem(Item ite) {
		Session ss = hu.getSession();
		Transaction tx = ss.beginTransaction();
		try {
			ss.update(ite);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {

		}
	}

	@Override
	public void deleteItem(Item ite) {
		Session ss = hu.getSession();
		Transaction tx = ss.beginTransaction();
		try {
			ss.delete(ite);
		} catch (Exception e) {
			tx.rollback();
		}
	}

	@Override
	public void deleteItemById(int id) {
		Session ss = hu.getSession();
		Transaction tx = ss.beginTransaction();
		try {
			Item ite = getItemById(id);
			ss.delete(ite);
		} catch (Exception e) {
			tx.rollback();
		}
	}

}
