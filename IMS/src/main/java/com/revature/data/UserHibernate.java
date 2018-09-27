package com.revature.data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.revature.beans.User;

@Component
public class UserHibernate implements UserDAO {
	private Session session;
	@Override
	public void setSession(Session session) {
		this.session = session;
	}
	
	@Override
	public int addUser(User use) {
		return (int) session.save(use);
	}
	@Override
	public User getUserById(int id) {
		return session.get(User.class, id);
	}
	@Override
	public List<User> getUsersCriteria(User use) {
		ArrayList<Predicate> preds = new ArrayList<Predicate>();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<User> cr = cb.createQuery(User.class);
		Root<User> root = cr.from(User.class);
		
		if(use.getEmail()!=null) {
			Predicate pr = cb.like(root.get("email"), use.getEmail());
			preds.add(pr);
		}
		if(use.getPassword()!=null) {
			crit.add(Restrictions.eq("password",use.getPassword()));
		}
		if(use.getId()!=0) {
			crit.add(Restrictions.eq("id",use.getId()));
		}
		if(use.getFirst()!=null) {
			crit.add(Restrictions.eq("fname",use.getFirst()));
		}
		if(use.getLast()!=null) {
			crit.add(Restrictions.eq("lname",use.getLast()));
		}
		if(use.getUsertype()!=null) {
			crit.add(Restrictions.eq("usertype",use.getUsertype()));
		}
		if(use.getPhone()!=null) {
			crit.add(Restrictions.eq("phone",use.getPhone()));
		}
		List<User> userList = cr.select(root).where(preds.toArray());
		return userList;
	}
	@Override
	public Set<User> getUsers() {
		String hql = "FROM com.revature.beans.User";
		Query<User> que = session.createQuery(hql, User.class);
		List<User> userList = que.getResultList();
		session.close();
		return new HashSet<User>(userList);
	}
	@Override
	public void updateUser(User use) {
		Transaction tx = session.beginTransaction();
		try {
			session.update(use);
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
	}
	@Override
	public void deleteUser(User use) {
		Transaction tx = session.beginTransaction();
		try {
			session.delete(use);
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
		}
		
	}
	@Override
	public User getUserLogin(String email, String password) {
//		Session se = hu.getSession();
//		User use = session.get(User.class,  email, password);
		return null;
	}
	
	
}
