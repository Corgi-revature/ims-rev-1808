package com.revature.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.beans.Delivery;
import com.revature.services.DeliveryService;

@Controller
@RequestMapping(value="/Delivery")
public class DeliveryController {

	@Autowired
	private DeliveryService ds;
	


}


