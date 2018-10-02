package com.revature.data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	public int addUser(User use) {
		Session ss = hu.getSession();
		int result = 0;
		Transaction tx = ss.beginTransaction();
		try {
			tx = ss.beginTransaction();
			result = (int)ss.save(use);
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
		} finally {

		}
		return result;
	}
	@Override
	public User getUserById(int id) {
		Session ss = hu.getSession();
		return ss.get(User.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsersCriteria(User user) {
		Session ss = hu.getSession();
		List<User> result = null;
		try {
			String hql = "FROM com.revature.beans.User u " + "WHERE lower(u.email) = ? AND u.password = ?";
//			Query query = ss.createQuery(hql);
			result = ss.createQuery(hql).setParameter(0, user.getEmail().toLowerCase()).setParameter(1, user.getPassword()).list();
		} catch (Exception e) {
	         e.printStackTrace();
	         
		} finally {

		}
		return result;
	}
	@Override
	public Set<User> getUsers() {
		Session ss = hu.getSession();
		String hql = "FROM com.revature.beans.User";
		Query<User> que = ss.createQuery(hql, User.class);
		List<User> userList = que.getResultList();

		return new HashSet<User>(userList);
	}
	@Override
	public void updateUser(User use) {
		Session ss = hu.getSession();
		Transaction tx = ss.beginTransaction();
		try {
			ss.update(use);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {

		}
	}
	@Override
	public void deleteUser(User use) {
		Session ss = hu.getSession();
		Transaction tx = ss.beginTransaction();
		try {
			ss.delete(use);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {

		}
	}
}