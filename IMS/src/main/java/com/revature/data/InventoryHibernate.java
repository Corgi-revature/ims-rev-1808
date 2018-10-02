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

import com.revature.beans.Inventory;
import com.revature.utils.HibernateUtil;

@Component
public class InventoryHibernate implements InventoryDAO {

	@Autowired
	private HibernateUtil hu;
	
	@Override
	public int addInventory(Inventory inv) {
		int sa = 0;
		Session ss = hu.getSession();
		Transaction tx = ss.beginTransaction();
		try {
			sa = (int)ss.save(inv);
			tx.commit();
			return sa;
		} catch (Exception e) {
			tx.rollback();
		} finally {
		}
		return sa;
	}

	@Override
	public Inventory getInventoryById(int id) {
		Session ss = hu.getSession();
		return ss.get(Inventory.class, id);
	}

	@Override
	public List<Inventory> getInventoryCriteria() {
		Session ss = hu.getSession();
		CriteriaBuilder build = ss.getCriteriaBuilder();
		CriteriaQuery<Inventory> crit = build.createQuery(Inventory.class);
		Root<Inventory> root = crit.from(Inventory.class);
		crit.select(root);
		List<Inventory> items = ss.createQuery(crit).getResultList();
		return new ArrayList<Inventory>(items);
	}

	@Override
	public Set<Inventory> getInventory() {
		Session ss = hu.getSession();
		String hql = "FROM com.revature.beans.Inventory";
		Query<Inventory> que = ss.createQuery(hql, Inventory.class);
		List<Inventory> itemList = que.getResultList();
		return new HashSet<Inventory>(itemList);
	}

	@Override
	public void updateInventory(Inventory inv) {
		Session ss = hu.getSession();
		Transaction tx = ss.beginTransaction();
		try {
			ss.update(inv);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
		}
	}

	@Override
	public void deleteInventory(Inventory inv) {
		Session ss = hu.getSession();
		Transaction tx = ss.beginTransaction();
		try {
			ss.delete(inv);
		} catch (Exception e) {
			tx.rollback();
		}
	}

	@Override
	public void deleteInventoryById(int id) {
		Session ss = hu.getSession();
		Transaction tx = ss.beginTransaction();
		try {
			Inventory inv = getInventoryById(id);
			ss.delete(inv);
		} catch (Exception e) {
			tx.rollback();
		}
	}

}
