package com.cts.sbtutorial1.services;

import java.util.List;

import org.springframework.security.core.userdetails.User;

import com.cts.sbtutorial1.domain.UserDao;

public interface UserService {
	public void deleteUser(String user);
	public void createUser(String user, String password);
	public User getUser(String user);
	public void setDataSource();
	public boolean checkIfExists(String username);
	public List<UserDao> getAllUsers();
}
