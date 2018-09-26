package com.revature.services;

import java.util.List;
import com.revature.beans.Txact;

public interface TxactService {
	List<Txact> getTxacts();
	Txact getTxactById(Integer id);
	Txact getTxactCriteria();
	
	// Returns no value
	/*void createTxact();
	void updateTxact();	
	void deleteTxact();*/
	
	// Returns value
	Integer createTxact(Integer id);
	Integer updateTxact(Integer id);	
	Integer deleteTxact(Integer id);
}
