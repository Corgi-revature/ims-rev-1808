package com.revature.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.beans.User;
import com.revature.services.LoginService;

@Controller
@RequestMapping(value = "/login")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {
	@Autowired
	private LoginService ls;

	@RequestMapping(method = RequestMethod.GET)
	public String goLogin(HttpSession session) {
		if (session.getAttribute("user") != null)
			return "redirect:home";
		return "static/login.html";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String login(String username, String password, HttpSession session) {
		User u = ls.login(username, password);
		if (u == null) {
			return "Login Failed";
		} else {
			session.setAttribute("user", u);
			return "Sucess";
		}
	}
	// will be removed
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String byPassLogin() {
		return "/static/hello.html";
	}
}
