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
		return ts.getTxactById(id);
	}

	@Override
	public Set<Txact> getTxacts() {
		return ts.getTxacts();
	}

	@Override
	public List<Txact> getTxactsCriteria(Txact txa) {
		return ts.getTxactsCriteria(txa);
	}

	@Override
	public void updateTxact(Txact txa) {
		ts.updateTxact(txa);
		
	}

	@Override
	public void deleteTxact(Txact txa) {
		ts.deleteTxact(txa);
	}

	@Override
	public void deleteTxactById(int id) {
		ts.deleteTxactById(id);
	}

	
}
