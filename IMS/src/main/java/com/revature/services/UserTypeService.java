package com.revature.services;

import java.util.List;
import java.util.Set;

import com.revature.beans.UserType;

public interface UserTypeService {
	public int addUserType(UserType utype);
	public UserType getUserTypeById(int id);
	Set<UserType> getUserTypes();
	List<UserType> getUserTypesCriteria(UserType utype);
	public void updateUserType(UserType utype);	
	public void deleteUserType(UserType utype);
	public void deleteUserTypeById(int id);
}
