package com.revature.data;

import java.util.Set;

import com.revature.beans.Txact;

public interface TxactDAO {
	public Txact addTxact(Txact txa);
	public Txact getTxactById(int id);
	public Set<Txact> getTxactsCriteria();
	public Set<Txact> getTxacts();
	public void updateTxact(Txact txa);
	public void deleteTxact(Txact txa);
	public void deleteTxactById(int id);
}
