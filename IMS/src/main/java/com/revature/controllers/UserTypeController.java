package com.revature.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.UserType;
import com.revature.services.UserTypeService;


@RestController
@RequestMapping(value = "/usertype")
@CrossOrigin(origins = "http://localhost:4200")
public class UserTypeController {
	
	@Autowired
	private UserTypeService uts;
	
	@RequestMapping(method = RequestMethod.POST)
	int addUserType(@RequestBody UserType utype) {
		return uts.addUserType(utype);
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	UserType getUserTypeById(@PathVariable int id) {
		return uts.getUserTypeById(id);
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	Set<UserType> getUserTypes() {
		return uts.getUserTypes();
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	List<UserType> getUserTypeCriteria(@RequestBody UserType utype) {
		//return uts.getUserTypeCriteria(utype);
		return null;
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	void updateItem(@RequestBody UserType utype) {
		uts.updateUserType(utype);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	void deleteItem(@RequestBody UserType utype) {
		uts.deleteUserType(utype);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	void deleteItemById(@PathVariable int id) {
		uts.deleteUserTypeById(id);
	}

}
