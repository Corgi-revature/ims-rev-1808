package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.User;
import com.revature.services.UserService;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	//checked
	@Autowired
	private UserService us;

	@RequestMapping(method = RequestMethod.GET)
	public String goLogin(HttpSession session) {
		if (session.getAttribute("user") != null) {
			
		}
		return "";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public List<User> login(User user) {
		
		List<User> u = us.getUsersCriteria(user);
		if (u == null) {
			return null;
		}
		return null;
	}
	//	testing
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String byPassLogin() {
		return "/static/hello.html";
	}
}
