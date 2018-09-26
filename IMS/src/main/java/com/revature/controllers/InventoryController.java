package com.revature.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.beans.Item;
import com.revature.services.InventoryService;

@Controller
@RequestMapping(value="/Inventory")
public class InventoryController {
	
	@Autowired
	private InventoryService is;
	
	
}