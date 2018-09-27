package com.revature.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.User;
import com.revature.data.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO ud;

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsersCriteria(User use) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(User use) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getUserLogin(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}


}
