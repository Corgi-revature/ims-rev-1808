package com.revature.data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.Item;
import com.revature.beans.Supplier;
import com.revature.utils.HibernateUtil;

@Component
public class SupplierHibernate implements SupplierDAO {
	@Autowired
	private HibernateUtil hu;

	@Override
	public int addSupplier(Supplier sup) {
		int sa = 0;
		Session ss = hu.getSession();
		Transaction tx = ss.beginTransaction();
		try {
			sa = (int)ss.save(sup);
			tx.commit();
			return sa;
		} catch (Exception e) {
			tx.rollback();
		} finally {
		}
		return sa;
	}

	@Override
	public Supplier getSupplierById(int id) {
		Session ss = hu.getSession();
		return ss.get(Supplier.class, id);
	}

	@Override
	public Set<Supplier> getSuppliersCriteria() {
		Session ss = hu.getSession();
		return null;
	}

	@Override
	public Set<Supplier> getSuppliers() {
		Session ss = hu.getSession();
		String hql = "FROM com.revature.beans.Supplier";
		Query<Supplier> que = ss.createQuery(hql, Supplier.class);
		List<Supplier> supplierList = que.getResultList();
		return new HashSet<Supplier>(supplierList);
	}

	@Override
	public void updateSupplier(Supplier sup) {
		Session ss = hu.getSession();
		Transaction tx = ss.beginTransaction();
		try {
			ss.update(sup);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {

		}

	}

	@Override
	public void deleteSupplier(Supplier sup) {
		Session ss = hu.getSession();
		Transaction tx = ss.beginTransaction();
		try {
			ss.delete(sup);
		} catch (Exception e) {
			tx.rollback();
		}
	}

	@Override
	public void deleteSupplierById(int id) {
		Session ss = hu.getSession();
		Transaction tx = ss.beginTransaction();
	}

}
