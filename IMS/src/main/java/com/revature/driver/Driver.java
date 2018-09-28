package com.revature.driver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.data.UserDAO;

public class Driver {
	//private static Logger log = Logger.getLogger(Driver.class);
	private static ApplicationContext ac;
	
	public static void main(String[] args) {
		ac = new ClassPathXmlApplicationContext("beans.xml");
		UserDAO ud = (UserDAO) ac.getBean(UserDAO.class);
		System.out.println(ud.getUserById(1));
		System.exit(0);
	}
}
