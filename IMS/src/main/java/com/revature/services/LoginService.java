package com.revature.services;

import com.revature.beans.User;

public interface LoginService {
	User login(String email, String password);
}
