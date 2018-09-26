package com.revature.data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.beans.Order;
import com.revature.utils.HibernateUtil;

public class OrderHibernate implements OrderDAO{
	private Logger log = Logger.getLogger(UserHibernate.class);
	HibernateUtil hu = HibernateUtil.getInstance();
	Transaction tx = null;

	@Override
	public Order addOrder(Order ord) {
		Session se = hu.getSession();
		try {
			tx = se.beginTransaction();
			se.save(ord);
			tx.commit();
			return ord;
		} catch(Exception e) {
			tx.rollback();
			log.trace(e.getMessage());
			return null;
		} finally {
			se.close();
		}
	}

	@Override
	public Order getOrderById(int id) {
		Session se = hu.getSession();
		Order ord = se.get(Order.class,  id);
		return ord;
	}

	@Override
	public Set<Order> getOrdersCriteria() {
		Session se = hu.getSession();
		CriteriaBuilder build = se.getCriteriaBuilder();
		CriteriaQuery<Order> crit = build.createQuery(Order.class);
		Root<Order> root = crit.from(Order.class);
		crit.select(root);
		List<Order> orders = se.createQuery(crit).getResultList();
		return new HashSet<Order>(orders);
		
	}

	@Override
	public Set<Order> getOrders() {
		Session se = hu.getSession();
		String hql = "FROM com.revature.beans.Order";
		Query<Order> que = se.createQuery(hql, Order.class);
		List<Order> orderList = que.getResultList();
		se.close();
		return new HashSet<Order>(orderList);
	}

	@Override
	public void updateOrder(Order ord) {
		Session se = hu.getSession();
		Transaction tx = se.beginTransaction();
		try {
			se.update(ord);
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
			log.trace(e.getMessage());
		} finally {
			se.close();
		}
		
	}

	@Override
	public void deleteOrder(Order ord) {
		Session se = hu.getSession();
		Transaction tx = se.beginTransaction();
		try {
			se.delete(ord);
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
			log.trace(e.getMessage());
		}
		
	}

	@Override
	public void deleteOrderById(int id) {
		// TODO Auto-generated method stub
		
	}
	
}
