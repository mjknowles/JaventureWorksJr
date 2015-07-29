package com.cts.sbtutorial1.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

import com.cts.sbtutorial1.domain.UserDao;
import com.cts.sbtutorial1.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private DataSource datasource;
	
	@Autowired
	private UserRepository userRepository;
	private JdbcUserDetailsManager userDetailsService;
	private PasswordEncoder encoder;
	
	public UserServiceImpl(){
		userDetailsService = new JdbcUserDetailsManager();
		encoder = new BCryptPasswordEncoder();
	}
	@Override
	public void setDataSource(){
		userDetailsService.setDataSource(datasource);
	}
	
	@Override
	public void deleteUser(String user) {
		userDetailsService.deleteUser(user);
	}

	@Override
	public void createUser(String username, String password) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("USER"));
        User userDetails = new User(username, encoder.encode(password), authorities);
		userDetailsService.createUser(userDetails);
	}
	
	
	@Override
	public User getUser(String username) {
		if(userDetailsService.userExists(username)){
			return (User) userDetailsService.loadUserByUsername(username);
		}
		return null;
	}
	
	@Override
	public boolean checkIfExists(String username) {
		
		return userDetailsService.userExists(username);
	}
	
	@Override
	public List<UserDao> getAllUsers() {
		return userRepository.findAll();
	}

}
