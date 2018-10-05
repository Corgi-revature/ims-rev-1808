package com.revature.data;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.TotalReport;
import com.revature.utils.HibernateUtil;

@Service
public class TotalReportHibernate implements TotalReportDAO {
	@Autowired
	private HibernateUtil hu;
	
	@Override	
	public TotalReport getReport(){
		Session ss = hu.getSession();
		String hql = "FROM com.revature.beans.TotalReport";
		TypedQuery<TotalReport> que = ss.createQuery(hql, TotalReport.class);
		List<TotalReport> orderList = que.getResultList();
		return orderList.get(0);
	}
}
