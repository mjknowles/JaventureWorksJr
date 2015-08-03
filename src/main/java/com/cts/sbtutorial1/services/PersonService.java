package com.cts.sbtutorial1.services;

import java.util.List;

import com.cts.sbtutorial1.domain.Person;

public interface PersonService {

	public List<Person> getAllPeople();
	public void deletePerson(int id);
	public void savePerson(Person person);
	public Person getPersonByID(int id);
}
