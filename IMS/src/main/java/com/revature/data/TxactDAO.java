package com.revature.data;

import java.util.List;
import java.util.Set;

import com.revature.beans.Txact;

public interface TxactDAO {
	public int addTxact(Txact txa);
	public Txact getTxactById(int id);
	public List<Txact> getTxactsCriteria();
	public Set<Txact> getTxacts();
	public void updateTxact(Txact txa);
	public void deleteTxact(Txact txa);
	public void deleteTxactById(int id);
}
