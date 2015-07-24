package com.cts.sbtutorial1.services;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cts.sbtutorial1.domain.Person;
import com.cts.sbtutorial1.repositories.PersonRepository;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {
	
    private final Logger log = LoggerFactory.getLogger(PersonServiceImpl.class);
	
    @Inject
    private PersonRepository personRepository;
    
	public List<Person> GetAllPeople(){
        log.debug("Service request to get all people");
		return personRepository.findAll();
	}

	@Override
	public void deletePerson(int id) {
		log.debug("Service request to delete a person.");
		personRepository.delete(id);
	}

	@Override
	public void savePerson(Person person) {
		log.debug("Service request to save a person.");
		personRepository.save(person);
		
	}

	@Override
	public Person getPersonByID(int id) {
		log.debug("Service request to get a person by their ID.");
		return personRepository.findOne(id);
	}
}
