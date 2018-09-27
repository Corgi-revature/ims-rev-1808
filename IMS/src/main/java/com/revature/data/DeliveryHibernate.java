package com.revature.data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

<<<<<<< HEAD
import org.hibernate.Session;
=======
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
>>>>>>> 9e67316221ca644f9f6176b9c1d2f56a4eb11ba7
import org.springframework.stereotype.Component;

import com.revature.beans.Delivery;

@Component
public class DeliveryHibernate implements DeliveryDAO {
	private Session session;
	@Override
	public void setSession(Session session) {
		this.session = session;
	}
	
	@Override
	public int addDelivery(Delivery deli) {
		return (int) session.save(deli);
	}

	@Override
	public Delivery getDeliveryById(int id) {
		return session.get(Delivery.class, id);
	}

	@Override
	public Set<Delivery> getDeliveriesCriteria() {
		CriteriaBuilder build = session.getCriteriaBuilder();
		CriteriaQuery<Delivery> crit = build.createQuery(Delivery.class);
		Root<Delivery> root = crit.from(Delivery.class);
		crit.select(root);
		List<Delivery> deliveries = session.createQuery(crit).getResultList();
		return new HashSet<Delivery>(deliveries);
	}

	@Override
	public Set<Delivery> getDeliveries() {
		String hql = "FROM com.revature.beans.Delivery";
		Query<Delivery> que = session.createQuery(hql, Delivery.class);
		List<Delivery> deliveries = que.getResultList();
		session.close();
		return new HashSet<Delivery>(deliveries);
	}

	@Override
	public void updateDelivery(Delivery deli) {
		Transaction tx = session.beginTransaction();
		try {
			session.update(deli);
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteDelivery(Delivery deli) {
		Transaction tx = session.beginTransaction();
		try {
			session.delete(deli);
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
		}
	}

	@Override
	public void deleteDeliveryById(int id) {
		Set<Delivery> deliveries = getDeliveries();
		for(Delivery deli : deliveries) {
			if(deli.getId()==id) {
				session.delete(deli);
				break;
			}
		}
	}

}
