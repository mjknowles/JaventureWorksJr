package com.cts.sbtutorial1.services;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.cts.sbtutorial1.domain.Person;
import com.cts.sbtutorial1.repositories.PersonRepository;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {
	
    private final Logger log = LoggerFactory.getLogger(PersonServiceImpl.class);
	
    @Inject
    private PersonRepository personRepository;
    
    //Here Cacheable only has a name and generates its own key.
    @Cacheable("people")
	public List<Person> getAllPeople(){
        log.debug("Service request to get all people");
		return personRepository.findAll();
	}
    
    //The Caching annotation is used to have multiple evictions or puts.
    @Caching(evict={@CacheEvict(value="person", key="#id"), 
    		@CacheEvict("people")})
	@Override
	public void deletePerson(int id) {
		log.debug("Service request to delete a person.");
		personRepository.delete(id);
	}
    
    //The CacheEvict will take out entries for the specific cache name
    @CacheEvict("people")
	@Override
	public void savePerson(Person person) {
		log.debug("Service request to save a person.");
		personRepository.save(person);
		
	}

    //Cacheable saves the cache entry with the given name by a specified ID
    //here value is the name and key is the id.
    @Cacheable(value="person", key="#id")
	@Override
	public Person getPersonByID(int id) {
		log.debug("Service request to get a person by their ID.");
		return personRepository.findOne(id);
	}
}
