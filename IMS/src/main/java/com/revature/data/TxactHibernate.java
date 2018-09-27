package com.revature.data;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.Txact;
import com.revature.utils.HibernateUtil;

@Component
public class TxactHibernate implements TxactDAO {
	@Autowired
	private HibernateUtil hu;
	
	@Override
	public Txact addTxact(Txact txa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Txact getTxactById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Txact> getTxactsCriteria() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Txact> getTxacts() {
		// TODO Auto-generated method stub
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
