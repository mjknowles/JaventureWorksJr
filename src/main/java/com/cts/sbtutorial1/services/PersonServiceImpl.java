package com.cts.sbtutorial1.services;

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
    
	public Iterable<Person> GetAllPeople(){
        log.debug("Service request to get all people");
		return personRepository.findAll();
	}
}
