package com.revature.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.UserType;
import com.revature.data.UserTypeDAO;

@Service
public class UserTypeServiceImpl implements UserTypeService {
	
	@Autowired
	UserTypeDAO utd;

	@Override
	public int addUserType(UserType utype) {
		return utd.addUserType(utype);
	}

	@Override
	public UserType getUserTypeById(int id) {
		return utd.getUserTypeById(id);
	}

	@Override
	public Set<UserType> getUserTypes() {
		return utd.getUserTypes();
	}

	@Override
	public List<UserType> getUserTypesCriteria(UserType utype) {
		return utd.getUserTypeCriteria(utype);
	}

	@Override
	public void updateUserType(UserType utype) {
		utd.updateUserType(utype);

	}

	@Override
	public void deleteUserType(UserType utype) {
		utd.deleteUserType(utype);

	}

	@Override
	public void deleteUserTypeById(int id) {
		utd.deleteUserTypeById(id);
	}

}
