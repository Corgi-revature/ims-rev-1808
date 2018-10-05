package com.revature.data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.Order;
import com.revature.utils.HibernateUtil;

@Component
public class OrderHibernate implements OrderDAO{
	@Autowired
	private HibernateUtil hu;

	@Override
	public int addOrder(Order ord) {
		Session ss = hu.getSession();
		int result = 0;
		Transaction tx = null;
		try {
			tx = ss.beginTransaction();
			result = (int)ss.save(ord);
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
		} finally {

		}
		return result;
	}

	@Override
	public Order getOrderById(int id) {
		Session ss = hu.getSession();
		Order ord = ss.get(Order.class,  id);
		return ord;
	}

	@Override
	public List<Order> getOrdersCriteria(Order ord) {
		Session ss = hu.getSession();
		CriteriaBuilder build = ss.getCriteriaBuilder();
		CriteriaQuery<Order> crit = build.createQuery(Order.class);
		Root<Order> root = crit.from(Order.class);
		crit.select(root);
		List<Order> orders = ss.createQuery(crit).getResultList();
		return new ArrayList<Order>(orders);
		
	}

	@Override	
	public Set<Order> getOrders() {
		Session ss = hu.getSession();
		String hql = "FROM com.revature.beans.Order";
		Query<Order> que = ss.createQuery(hql, Order.class);
		List<Order> orderList = que.getResultList();
		return new HashSet<Order>(orderList);
	}

	@Override
	public void updateOrder(Order ord) {
		Session ss = hu.getSession();
		Transaction tx = ss.beginTransaction();
		try {
			ss.update(ord);
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
		} finally {

		}
		
	}

	@Override
	public void deleteOrder(Order ord) {
		Session ss = hu.getSession();
		Transaction tx = ss.beginTransaction();
		try {
			ss.delete(ord);
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
		}
		
	}

	@Override
	public void deleteOrderById(int id) {
		Session ss = hu.getSession();
		Transaction tx = ss.beginTransaction();
		
	}
	
}
