package com.revature.services;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Txact> getTxacts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Txact> getTxactsCriteria() {
		// TODO Auto-generated method stub
		System.out.println("stumbled upone txact Criteria");
		return null;
	}

	@Override
	public void updateTxact(Txact txa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTxact(Txact txa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTxactById(int id) {
		// TODO Auto-generated method stub
		
	}

	
}
