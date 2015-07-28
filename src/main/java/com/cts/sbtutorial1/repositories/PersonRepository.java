package com.cts.sbtutorial1.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cts.sbtutorial1.domain.Person;

public interface PersonRepository extends CrudRepository<Person, Integer>{
	public List<Person> findAll();
}
