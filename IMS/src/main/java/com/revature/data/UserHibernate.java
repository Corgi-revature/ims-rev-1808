package com.revature.data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.User;
import com.revature.utils.HibernateUtil;

@Component
public class UserHibernate implements UserDAO {
	@Autowired
	private HibernateUtil hu;

	@Override
	public int addUser(User user) {
		Session ss = hu.getSession();
		Transaction ts = ss.beginTransaction();
		return (int) ss.save(user);
	}

	@Override
	public User getUserById(int id) {
		return ss.get(User.class, id);
	}

	@Override
	public List<User> getUsersCriteria(User user) {
		ArrayList<Predicate> preds = null;
		CriteriaBuilder cb = ss.getCriteriaBuilder();
		CriteriaQuery<User> cr = cb.createQuery(User.class);
		Root<User> root = cr.from(User.class);
		cr.select(root);
		List<User> users = ss.createQuery(cr).getResultList();
		return users;
	}

	@Override
	public Set<User> getUsers() {
		String hql = "FROM com.revature.beans.User";
		Query<User> que = ss.createQuery(hql, User.class);
		List<User> userList = que.getResultList();
		ss.close();
		return new HashSet<User>(userList);
	}

	@Override
	public void updateUser(User user) {
		Transaction tx = ss.beginTransaction();
		try {
			ss.update(user);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			ss.close();
		}
	}

	@Override
	public void deleteUser(User user) {
		Transaction tx = ss.beginTransaction();
		try {
			ss.delete(user);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			ss.close();
		}
	}
}
