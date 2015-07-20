package com.cts.sbtutorial1.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cts.sbtutorial1.domain.Person;

public interface PersonRepository extends CrudRepository<Person, Integer>{

}
