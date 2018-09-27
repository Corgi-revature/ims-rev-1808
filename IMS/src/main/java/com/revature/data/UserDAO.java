package com.revature.data;

import java.util.List;
import java.util.Set;

import com.revature.beans.User;

public interface UserDAO extends HibernateSession {
	public int addUser(User user);
	public User getUserById(int id); 
	public List<User> getUsersCriteria(User use);
	public Set<User> getUsers();
	public void updateUser(User user);
	public void deleteUser(User user);
}
