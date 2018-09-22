package com.revature.data;

import java.util.Set;

import com.revature.beans.User;

public interface UserDAO {
	User addUser(User user);
	User getUserByLogin(String username, String password);
	Set<User> getUsersCriteria();
	Set<User> getUsersHQL();
	User updateUser(User user);
	void deleteUser(User user);
}
