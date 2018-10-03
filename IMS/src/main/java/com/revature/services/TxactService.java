package com.revature.services;

import java.util.List;
import java.util.Set;

import com.revature.beans.Txact;

public interface TxactService {
	
	int addTxact(Txact txa);
	Txact getTxactById(int id);
	Set<Txact> getTxacts();
	List<Txact> getTxactsCriteria();	
	void updateTxact(Txact txa);	
	void deleteTxact(Txact txa);
	void deleteTxactById(int id);
}
