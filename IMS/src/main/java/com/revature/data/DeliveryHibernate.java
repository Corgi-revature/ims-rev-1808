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

import com.revature.beans.Delivery;
import com.revature.utils.HibernateUtil;

@Component
public class DeliveryHibernate implements DeliveryDAO {
	@Autowired
	private HibernateUtil hu;
	
	@Override
	public int addDelivery(Delivery deli) {
		Session ss = hu.getSession();
		int result = 0;
		Transaction tx = null;
		try {
			tx = ss.beginTransaction();
			result = (int)ss.save(deli);
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
		} finally {

		}
		return result;
	}
	
	@Override
	public Delivery getDeliveryById(int id) {
		Session ss = hu.getSession();
		return ss.get(Delivery.class, id);
	}

	@Override
	public List<Delivery> getDeliveriesCriteria(Delivery deli) {
		Session ss = hu.getSession();
		CriteriaBuilder build = ss.getCriteriaBuilder();
		CriteriaQuery<Delivery> crit = build.createQuery(Delivery.class);
		Root<Delivery> root = crit.from(Delivery.class);
		crit.select(root);
		List<Delivery> deliveries = ss.createQuery(crit).getResultList();
		return new ArrayList<Delivery>(deliveries);
	}

	@Override
	public Set<Delivery> getDeliveries() {
		Session ss = hu.getSession();
		String hql = "FROM com.revature.beans.Delivery";
		Query<Delivery> que = ss.createQuery(hql, Delivery.class);
		List<Delivery> deliveries = que.getResultList();
		return new HashSet<Delivery>(deliveries);
	}

	@Override
	public void updateDelivery(Delivery deli) {
		Session ss = hu.getSession();
		Transaction tx = ss.beginTransaction();
		try {
			ss.update(deli);
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
		} finally {
		}
	}

	@Override
	public void deleteDelivery(Delivery deli) {
		Session ss = hu.getSession();
		Transaction tx = ss.beginTransaction();
		try {
			ss.delete(deli);
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
		}
	}

	@Override
	public void deleteDeliveryById(int id) {
		Session ss = hu.getSession();
		Transaction tx = ss.beginTransaction();
		Set<Delivery> deliveries = getDeliveries();
		for(Delivery deli : deliveries) {
			if(deli.getId()==id) {
				ss.delete(deli);
				tx.commit();
				break;
			}
		}
	}

}
