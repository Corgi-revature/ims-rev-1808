package com.revature.data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.beans.Item;
import com.revature.beans.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.utils.HibernateUtil;

@Component
public class UserTypeHibernate implements UserTypeDAO {

	@Autowired
	private HibernateUtil hu;
	
	@Override
	public int addUserType(UserType utype) {
		Session ss = hu.getSession();
		int result = 0;
		Transaction tx = null;
		try {
			tx = ss.beginTransaction();
			result = (int)ss.save(utype);
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
		} finally {

		}
		return result;
	}

	@Override
	public UserType getUserTypeById(int id) {
		Session ss = hu.getSession();
		UserType utype = ss.get(UserType.class,  id);
		return utype;
	}

	@Override
	public List<UserType> getUserTypeCriteria(UserType utype) {
		Session ss = hu.getSession();
		CriteriaBuilder build = ss.getCriteriaBuilder();
		CriteriaQuery<UserType> crit = build.createQuery(UserType.class);
		Root<UserType> root = crit.from(UserType.class);
		crit.select(root);
		List<UserType> types = ss.createQuery(crit).getResultList();
		return new ArrayList<UserType>(types);
	}

	@Override
	public Set<UserType> getUserTypes() {
		Session ss = hu.getSession();
		String hql = "FROM com.revature.beans.Order";
		Query<UserType> que = ss.createQuery(hql, UserType.class);
		List<UserType> typeList = que.getResultList();

		return new HashSet<UserType>(typeList);
	}

	@Override
	public void updateUserType(UserType utype) {
		Session ss = hu.getSession();
		Transaction tx = ss.beginTransaction();
		try {
			ss.update(utype);
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
		} finally {

		}

	}

	@Override
	public void deleteUserType(UserType utype) {
		Session ss = hu.getSession();
		Transaction tx = ss.beginTransaction();
		try {
			ss.delete(utype);
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
		}

	}
	
	@Override
	public void deleteUserTypeById(int id) {
		Session ss = hu.getSession();
		Transaction tx = ss.beginTransaction();
		try {
			UserType utype = getUserTypeById(id);
			ss.delete(utype);
		} catch (Exception e) {
			tx.rollback();
		}

	}

}
