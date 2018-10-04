package com.revature.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Txact;
import com.revature.data.TxactDAO;

@Service
public class TxactServiceImpl implements TxactService {
	@Autowired
	private TxactDAO ts;

	@Override
	public int addTxact(Txact txa) {
		return ts.addTxact(txa);
	}

	@Override
	public Txact getTxactById(int id) {
		return null;
	}

	@Override
	public Set<Txact> getTxacts() {
		return null;
	}

	@Override
	public List<Txact> getTxactsCriteria() {
		return null;
	}

	@Override
	public void updateTxact(Txact txa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTxact(Txact txa) {
	}

	@Override
	public void deleteTxactById(int id) {	
	}

	
}
