package com.cts.sbtutorial1.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.cts.sbtutorial1.domain.UserDao;

public interface UserRepository extends CrudRepository<UserDao, String>{
	public List<UserDao> findAll();
}
