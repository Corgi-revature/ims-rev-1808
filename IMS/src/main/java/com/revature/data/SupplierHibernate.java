package com.revature.data;

import java.util.Set;

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
		// TODO Auto-generated method stub
		return null;
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
