package com.revature.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.beans.Order;
import com.revature.services.OrderService;

@Controller
@RequestMapping(value="/Order")
public class OrderController {

	@Autowired
	private OrderService os;
	


}


