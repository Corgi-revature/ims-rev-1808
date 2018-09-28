package com.revature.data;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
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
		Session ss = hu.getSession();
		Transaction tx = ss.beginTransaction();
		return null;
	}

	@Override
	public Txact getTxactById(int id) {
		Session ss = hu.getSession();
		Transaction tx = ss.beginTransaction();
		return null;
	}

	@Override
	public Set<Txact> getTxactsCriteria() {
		Session ss = hu.getSession();
		Transaction tx = ss.beginTransaction();
		return null;
	}

	@Override
	public Set<Txact> getTxacts() {
		Session ss = hu.getSession();
		Transaction tx = ss.beginTransaction();
		return null;
	}

	@Override
	public void updateTxact(Txact txa) {
		Session ss = hu.getSession();
		Transaction tx = ss.beginTransaction();

	}

	@Override
	public void deleteTxact(Txact txa) {
		Session ss = hu.getSession();
		Transaction tx = ss.beginTransaction();
	}

	@Override
	public void deleteTxactById(int id) {
		Session ss = hu.getSession();
		Transaction tx = ss.beginTransaction();

	}

}
