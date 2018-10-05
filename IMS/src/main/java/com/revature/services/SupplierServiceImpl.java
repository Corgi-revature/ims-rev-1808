package com.revature.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Supplier;
import com.revature.data.SupplierDAO;
@Service
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	SupplierDAO sd;
	
	@Override
	public int addSupplier(Supplier sup) {
		return sd.addSupplier(sup);
	}

	@Override
	public Supplier getSupplierById(int id) {
		return sd.getSupplierById(id);
	}

	@Override
	public Set<Supplier> getSuppliers() {
		return sd.getSuppliers();
	}

	@Override
	public List<Supplier> getSuppliersCriteria(Supplier sup) {
		return sd.getSuppliersCriteria(sup);
	}

	@Override
	public void updateSupplier(Supplier sup) {
		sd.updateSupplier(sup);
	}

	@Override
	public void deleteSupplier(Supplier sup) {
		sd.deleteSupplier(sup);
	}

	@Override
	public void deleteSupplierById(int id) {
		sd.deleteSupplierById(id);
	}

}
