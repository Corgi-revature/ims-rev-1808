package com.revature.services;

import java.util.List;
import java.util.Set;

import com.revature.beans.User;
import com.revature.beans.UserType;

public interface UserService {
	public int addUser(User user);
	public User getUserById(int id);
	public List<User> getUsersCriteria(User user);
	public List<User> getUserByType(int i);
	public List<User> getEmp();
	public Set<User> getUsers();
	public void updateUser(User user);
	public void deleteUser(User user);
}
