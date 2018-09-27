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
		return ud.addUser(user);
	}

	@Override
	public User getUserById(int id) {
		return ud.getUserById(id);
	}

	@Override
	public List<User> getUsersCriteria(User user) {
		return ud.getUsersCriteria(user);
	}

	@Override
	public Set<User> getUsers() {
		return ud.getUsers();
	}

	@Override
	public void updateUser(User user) {
		ud.updateUser(user);
	}

	@Override
	public void deleteUser(User user) {
		ud.deleteUser(user);
	}
}
