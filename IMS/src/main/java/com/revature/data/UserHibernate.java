package com.revature.data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
<<<<<<< HEAD

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
=======
>>>>>>> a266438b0272fe526255b73a87f8e2ca33e9eaa1

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.User;

@Component
public class UserHibernate implements UserDAO {
	@Autowired
	private HibernateUtil hu;

	@Override
	public int addUser(User use) {
		Session ss = hu.getSession();
		Transaction tx = ss.beginTransaction();
		return (int) ss.save(use);
	}

	@Override
	public User getUserById(int id) {
		Session ss = hu.getSession();
		Transaction tx = ss.beginTransaction();
		return ss.get(User.class, id);
	}

	@Override
	public List<User> getUsersCriteria(User user) {
		Session ss = hu.getSession();
		Transaction tx = ss.beginTransaction();
		List<User> result = null;
		try {
			String hql = "FROM com.revature.beans.User u "
					+ "WHERE u.email = ? AND u.password = ?";
//			Query query = ss.createQuery(hql);
			result = ss.createQuery(hql)
					.setParameter(0, user.getEmail())
					.setParameter(1, user.getPassword()).list();
		} catch (Exception e) {
	         e.printStackTrace();
	         if (tx != null) {
	            tx.rollback();
	         }
		} finally {
			ss.close();
		}
		return result;
	}

	@Override
	public Set<User> getUsers() {
		Session ss = hu.getSession();
		Transaction tx = ss.beginTransaction();
		String hql = "FROM com.revature.beans.User";
		Query<User> que = ss.createQuery(hql, User.class);
		List<User> userList = que.getResultList();
		ss.close();
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
			ss.close();
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
			ss.close();
		}
	}
}