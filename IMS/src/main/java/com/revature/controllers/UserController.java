package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.User;
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

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public User login(@RequestBody User user) {
		User newUser = null;
		try {
			List<User> u = us.getUsersCriteria(user);
			if (u.size() != 0) {
				newUser = u.get(0);
			}
		} catch(Exception e) {
			return null;
		} finally {
			
		}
		return newUser;
	}

	// testing
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String byPassLogin() {
		return "/static/hello.html";
	}
}
