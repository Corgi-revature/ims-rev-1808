package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.User;
import com.revature.beans.UserType;
import com.revature.services.UserService;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	private UserService us;

	@RequestMapping(method = RequestMethod.GET)
	public String goLogin(String session) {
		if (session == null) {
//			log.trace(session);
//			log.trace(us.getUsers());
		}
		return "RUN";
	}
	
	@RequestMapping(value = "/employee/all",method = RequestMethod.GET)
	public List<User> getEmp() {
		List<User> emp= null;
		try {
			emp = us.getEmp();
			if (emp.size() != 0) {
				return emp;
			}
		} catch(Exception e) {
			return null;
		} finally {
			
		}
		return emp;
	}
	
	@RequestMapping(value = "/customer/all",method = RequestMethod.GET)
	public List<User> getCust() {
		List<User> cust= null;
		try {
			cust = us.getUserByType(1);
			if (cust.size() != 0) {
				return cust;
			}
		} catch(Exception e) {
			return null;
		} finally {
			
		}
		return cust;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<User> login(@RequestBody User user) {
		User newUser = null;
		try {
			List<User> u = us.getUsersCriteria(user);
			if (u.size() != 0) {
				newUser = u.get(0);
				return new ResponseEntity<User>(newUser, HttpStatus.OK);
			}
		} catch(Exception e) {
			return new ResponseEntity<User>(newUser, HttpStatus.BAD_REQUEST);
		} finally {
			
		}
		return new ResponseEntity<User>(newUser, HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value="/new", method=RequestMethod.POST)
	public int register(@RequestBody User user) {
		User newUser = null;
		try {
			newUser=user;
			int result = us.addUser(newUser);
			return result;
		} catch(Exception e) {
			
		} finally {
			
		}
		return 0;
	}

	// testing
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String byPassLogin() {
		return "User Controller says Hello";
	}
}