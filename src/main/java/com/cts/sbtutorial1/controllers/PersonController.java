package com.cts.sbtutorial1.controllers;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cts.sbtutorial1.domain.Person;
import com.cts.sbtutorial1.dto.PersonDto;
import com.cts.sbtutorial1.services.PersonService;


@Controller
public class PersonController extends BaseController{
	private final Logger log = LoggerFactory.getLogger(PersonController.class);
	
	@Inject
	private PersonService personService;
	
	
    @RequestMapping("/person")
    public ModelAndView addressIndex(){
    	ModelAndView mav = new ModelAndView("/person/index");
    	mav.addObject("people",personService.GetAllPeople());
    	log.debug("Got all people.");
    	
    	return mav;
    }
    
    @RequestMapping("/person/save")
    public ModelAndView personSave(PersonDto person){
    	ModelAndView mav = new ModelAndView("/person/create");
    	Person model = new Person();
    	
    	if(person != null){
    		model.setDateOfBirth(person.returnLocalBirthDate());
    		model.setFirstName(person.getFirstName());
    		model.setLastName(person.getLastName());
    		model.setId(person.getId());
    	}
    	
    	personService.savePerson(model);
    	log.debug("Person id " + model.getId() + " has been saved.");
    	person.setId(model.getId());
    	
    	mav.addObject("person", person);
    	
    	return mav;
    }
    
    @RequestMapping("/person/form")
    public ModelAndView personCreateForm(PersonDto person){
    	ModelAndView mav = new ModelAndView("/person/create");
    	if(person == null){
    		person = new PersonDto();
    	}
    	mav.addObject("person", person);
    	
    	return mav;
    }
}
