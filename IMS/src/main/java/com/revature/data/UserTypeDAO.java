package com.revature.data;

import java.util.List;
import java.util.Set;

import com.revature.beans.UserType;

public interface UserTypeDAO {

	public int addUserType(UserType utype);
	public UserType getUserTypeById(int id);
	public List<UserType> getUserTypeCriteria(UserType utype);
	public Set<UserType> getUserTypes();
	public void updateUserType(UserType utype);
	public void deleteUserType(UserType utype);
	public void deleteUserTypeById(int id);
}
