package com.revature.data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.revature.beans.Order;

@Component
public class OrderHibernate implements OrderDAO{
	private Session session;
	@Override
	public void setSession(Session session) {
		this.session = session;
	}
	Transaction tx = null;

	@Override
	public Order addOrder(Order ord) {
		try {
			tx = session.beginTransaction();
			session.save(ord);
			tx.commit();
			return ord;
		} catch(Exception e) {
			tx.rollback();
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public Order getOrderById(int id) {

		Order ord = session.get(Order.class,  id);
		return ord;
	}

	@Override
	public Set<Order> getOrdersCriteria() {

		CriteriaBuilder build = session.getCriteriaBuilder();
		CriteriaQuery<Order> crit = build.createQuery(Order.class);
		Root<Order> root = crit.from(Order.class);
		crit.select(root);
		List<Order> orders = session.createQuery(crit).getResultList();
		return new HashSet<Order>(orders);
		
	}

	@Override	
	public Set<Order> getOrders() {
		String hql = "FROM com.revature.beans.Order";
		Query<Order> que = session.createQuery(hql, Order.class);
		List<Order> orderList = que.getResultList();
		session.close();
		return new HashSet<Order>(orderList);
	}

	@Override
	public void updateOrder(Order ord) {

		Transaction tx = session.beginTransaction();
		try {
			session.update(ord);
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		
	}

	@Override
	public void deleteOrder(Order ord) {

		Transaction tx = session.beginTransaction();
		try {
			session.delete(ord);
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
		}
		
	}

	@Override
	public void deleteOrderById(int id) {
		// TODO Auto-generated method stub
		
	}
	
}
