package com.revature.data;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.Supplier;
import com.revature.utils.HibernateUtil;

@Component
public class SupplierHibernate implements SupplierDAO {
	@Autowired
	private HibernateUtil hu;

	@Override
	public Supplier addSupplier(Supplier sup) {
		Session ss = hu.getSession();
		Transaction tx = ss.beginTransaction();
		return (Supplier) ss.save(sup);
	}

	@Override
	public Supplier getSupplierById(int id) {
		Session ss = hu.getSession();
		return null;
	}

	@Override
	public Set<Supplier> getSuppliersCriteria() {
		Session ss = hu.getSession();
		return null;
	}

	@Override
	public Set<Supplier> getSuppliers() {
		Session ss = hu.getSession();
		return null;
	}

	@Override
	public void updateSupplier(Supplier sup) {
		Session ss = hu.getSession();
		Transaction tx = ss.beginTransaction();

	}

	@Override
	public void deleteSupplier(Supplier sup) {
		Session ss = hu.getSession();
		Transaction tx = ss.beginTransaction();
	}

	@Override
	public void deleteSupplierById(int id) {
		Session ss = hu.getSession();
		Transaction tx = ss.beginTransaction();
	}

}
