package com.revature.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.User;
import com.revature.services.UserService;

@RestController
@RequestMapping(value = "/login")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	@Autowired
	private UserService ls;

	@RequestMapping(method = RequestMethod.GET)
	public String goLogin(HttpSession session) {
		if (session.getAttribute("user") != null) {
			
		}
		return "";
	}

	@RequestMapping(method = RequestMethod.POST)
	public User login(String username, String password, HttpSession session) {
		User u = ls.getUserLogin(username, password);
		if (u == null) {
			return null;
		} else {
			session.setAttribute("user", u);
			return u;
		}
	}
	//	testing
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String byPassLogin() {
		return "/static/hello.html";
	}
}
