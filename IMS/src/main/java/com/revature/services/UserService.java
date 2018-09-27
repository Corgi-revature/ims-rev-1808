package com.revature.services;

import java.util.List;
import java.util.Set;

import com.revature.beans.User;

public interface UserService {
	public int addUser(User use);
	public User getUserById(int id);
	public List<User> getUsersCriteria(User use);
	public Set<User> getUsers();
	public User getUserLogin(String email, String password);
	public void updateUser(User use);
	public void deleteUser(User use);
}
