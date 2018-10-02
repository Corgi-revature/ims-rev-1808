package com.revature.services;

import java.util.List;
import java.util.Set;

import com.revature.beans.Supplier;

public interface SupplierService {
	public int addSupplier(Supplier sup);
	public Supplier getSupplierById(int id);
	public Set<Supplier> getSuppliers();
	public List<Supplier> getSuppliersCriteria();
	public void updateSupplier(Supplier sup);	
	public void deleteSupplier(Supplier sup);
	public void deleteSupplierById(int id);
}