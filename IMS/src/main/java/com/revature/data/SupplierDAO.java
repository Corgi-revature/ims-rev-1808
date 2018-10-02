package com.revature.data;

import java.util.Set;

import com.revature.beans.Supplier;

public interface SupplierDAO {
	public int addSupplier(Supplier sup);
	public Supplier getSupplierById(int id);
	public Set<Supplier> getSuppliersCriteria();
	public Set<Supplier> getSuppliers();
	public void updateSupplier(Supplier sup);
	public void deleteSupplier(Supplier sup);
	public void deleteSupplierById(int id);

}
