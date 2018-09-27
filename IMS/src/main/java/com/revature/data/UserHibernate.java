package com.revature.data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.User;
import com.revature.utils.HibernateUtil;

@Component
public class UserHibernate implements UserDAO {
	private Logger log = Logger.getLogger(UserHibernate.class);
	@Autowired
	private HibernateUtil hu;
	
	@Override
	public int addUser(User use) {
		Session se = hu.getSession();
		Transaction tx = null;
		try {
			tx = se.beginTransaction();
			int id = (Integer)se.save(use);
			tx.commit();
			return id;
		} catch (Exception e) {
			tx.rollback();
			log.trace(e.getMessage());
			return 0;
		} finally {
			se.close();
		}
	}
	@Override
	public User getUserById(int id) {
		Session se = hu.getSession();
		User use = se.get(User.class,  id);
		return use;
	}
	@Override
	public Set<User> getUsersCriteria() {
		Session se = hu.getSession();
		CriteriaBuilder build = se.getCriteriaBuilder();
		CriteriaQuery<User> crit = build.createQuery(User.class);
		Root<User> root = crit.from(User.class);
		crit.select(root);
		List<User> users = se.createQuery(crit).getResultList();
		return new HashSet<User>(users);
	}
	@Override
	public Set<User> getUsers() {
		Session se = hu.getSession();
		String hql = "FROM com.revature.beans.User";
		Query<User> que = se.createQuery(hql, User.class);
		List<User> userList = que.getResultList();
		se.close();
		return new HashSet<User>(userList);
	}
	@Override
	public void updateUser(User use) {
		Session se = hu.getSession();
		Transaction tx = se.beginTransaction();
		try {
			se.update(use);
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
			log.trace(e.getMessage());
		} finally {
			se.close();
		}
	}
	@Override
	public void deleteUser(User use) {
		Session se = hu.getSession();
		Transaction tx = se.beginTransaction();
		try {
			se.delete(use);
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
			log.trace(e.getMessage());
		}
		
	}
	@Override
	public User getUserLogin(String email, String password) {
//		Session se = hu.getSession();
//		User use = se.get(User.class,  email, password);
		return null;
	}
	
	
}
