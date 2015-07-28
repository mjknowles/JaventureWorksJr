package com.cts.sbtutorial1.controllers;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cts.sbtutorial1.domain.Person;
import com.cts.sbtutorial1.services.PersonService;

@Controller
public class PersonController {
	private final Logger log = LoggerFactory.getLogger(PersonController.class);
	
	@Inject
	private PersonService personService;
	
	@RequestMapping("/Person")
	String index(){
    	Iterable<Person> people = personService.GetAllPeople();
        log.debug("REST request to get all people");
		return "personList";
	}
}
