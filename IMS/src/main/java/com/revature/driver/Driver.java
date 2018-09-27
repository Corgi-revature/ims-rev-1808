package com.revature.driver;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.data.UserDAO;
import com.revature.data.UserHibernate;

public class Driver {
	private static Logger log = Logger.getLogger(Driver.class);
	private static ApplicationContext ac;
	
	public static void main(String[] args) {
		ac = new ClassPathXmlApplicationContext("beans.xml");
		UserDAO ud = (UserDAO) ac.getBean(UserDAO.class);
		System.out.println(ud.getUsers());
		System.exit(0);
	}

	private static void getUser(int id) {
		UserHibernate uh = new UserHibernate();
		log.trace(uh.getUserById(id));
	}
}
