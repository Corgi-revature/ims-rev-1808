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
@RequestMapping(value="/login")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {
	@Autowired
	private LoginService ls;
	
	// Direct someone to the login service if the session has no user
	@RequestMapping(method=RequestMethod.GET)
	public String goToLogin(HttpSession session) {
		if(session.getAttribute("user")!=null) {
			return "redirect:login";
		}
		else {
			return "static/login.html";
		}
	}

	// When someone tries to login, direct them to login service
	@RequestMapping(method=RequestMethod.POST) 
	public String login(String email, String password, HttpSession session) {
		User user = ls.login(email, password);
		if (user==null) {
			return "redirect:login";
		} else {
			session.setAttribute("user", user);
			return "redirect:login";
		}
	}
	
	// If someone tries to go to the 'Home' page, take them to login
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String byPassLogin() {
		return "/static/login.html";
	}
}


