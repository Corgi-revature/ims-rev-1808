package com.revature.data;

import java.util.Set;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.revature.beans.Txact;

@Component
public class TxactHibernate implements TxactDAO {
	private Session session;
	@Override
	public void setSession(Session session) {
		this.session = session;
	}
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
