package com.revature.data;

import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.beans.User;
import com.revature.utils.HibernateUtil;

public class UserHibernate implements UserDAO {
	private Logger log = Logger.getLogger(UserHibernate.class);
	private HibernateUtil hu = HibernateUtil.getInstance();
	
	@Override
	public User addUser(User user) {
		Session session = hu.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			int i = (Integer) session.save(user);
			tx.commit();
			return user;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}
	@Override
	public User getUserByLogin(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Set<User> getUsersCriteria() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Set<User> getUsersHQL() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}
	
	
}
