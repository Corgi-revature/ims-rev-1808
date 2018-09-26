package com.revature.data;

import java.util.Set;

import com.revature.beans.User;

public interface UserDAO {
	public int addUser(User user);
	public User getUserById(int id); 
	public Set<User> getUsersCriteria();
	public Set<User> getUsers();
	public void updateUser(User user);
	public void deleteUser(User user);
}
