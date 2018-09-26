package com.revature.services;

import java.util.Set;
import com.revature.beans.Txact;

public interface TxactService {
	
	Txact addTxact(Txact txa);
	Txact getTxactById(int id);
	Set<Txact> getTxacts();
	Set<Txact> getTxactsCriteria();	
	void updateTxact(Txact txa);	
	void deleteTxact(Txact txa);
	void deleteTxactById(int id);
}
