package com.revature.data;

import java.util.Set;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.revature.beans.Supplier;

@Component
public class SupplierHibernate implements SupplierDAO {
	private Session session;
	@Override
	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public Supplier addSupplier(Supplier sup) {
		return (Supplier) session.save(sup);
	}

	@Override
	public Supplier getSupplierById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Supplier> getSuppliersCriteria() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Supplier> getSuppliers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateSupplier(Supplier sup) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteSupplier(Supplier sup) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteSupplierById(int id) {
		// TODO Auto-generated method stub

	}

}
