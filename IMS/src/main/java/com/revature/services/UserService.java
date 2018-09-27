package com.revature.services;

import java.util.Set;

import com.revature.beans.User;

public interface UserService {
	public int addUser(User user);
	public User getUserById(int id); 
	public Set<User> getUsersCriteria();
	public Set<User> getUsers();
	public User getUserLogin(String email, String password);
	public void updateUser(User user);
	public void deleteUser(User user);
}
