package com.cts.sbtutorial1.services;

import org.springframework.security.core.userdetails.User;

public interface UserService {
	public void deleteUser(String user);
	public void createUser(String user, String password);
	public User getUser(String user);
}
