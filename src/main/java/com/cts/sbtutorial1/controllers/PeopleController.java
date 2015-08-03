package com.cts.sbtutorial1.controllers;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cts.sbtutorial1.domain.Address;
import com.cts.sbtutorial1.domain.Person;
import com.cts.sbtutorial1.domain.Store;
import com.cts.sbtutorial1.dto.AddressDto;
import com.cts.sbtutorial1.dto.PersonDto;
import com.cts.sbtutorial1.services.PersonService;
import com.cts.sbtutorial1.services.StoreService;


@Controller
@RequestMapping("/people")
public class PeopleController extends BaseController{

	private final Logger log = LoggerFactory.getLogger(PeopleController.class);
	
	@Inject
	private PersonService personService;
	
	@Inject
	private StoreService storeService;
	
    @RequestMapping(value = {"/", "", "/index"})	
    public ModelAndView index(){
    	ModelAndView mav = new ModelAndView("/people/index");
    	mav.addObject("people",personService.getAllPeople());
    	log.debug("Got all people.");
    	
    	return mav;
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create(){
    	ModelAndView mav = new ModelAndView("/people/create");
    	mav.addObject("person", new PersonDto());
    	mav.addObject("stores", storeService.getAllStores());
    	
    	return mav;
    }    
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(PersonDto person){
    	Person model = new Person();
    	
    	if(person != null){
    		model.setDateOfBirth(person.getLocalBirthDate());
    		model.setFirstName(person.getFirstName());
    		model.setLastName(person.getLastName());
    		model.setId(person.getId());
    		model.setStores(person.getStores());
    	}
    	
    	personService.savePerson(model);
    	log.debug("Person id " + model.getId() + " has been saved.");
    	    	
    	return "redirect:/people/index";
    }
    
    @RequestMapping(value = "/edit/{id}",
    		method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable int id){
  	
    	ModelAndView mav = new ModelAndView("/people/edit");
     	mav.addObject("person", personService.getPersonByID(id));
    	mav.addObject("allStores", storeService.getAllStores());

    	return mav;
    }    
    
    @RequestMapping(value = "/edit/{id}",
    		method = RequestMethod.POST)
    public String edit(PersonDto person){
    	Person model = new Person();
    	log.debug("Saving person.");
    	
    	if(person != null){
    		model.setFirstName(person.getFirstName());
    		model.setLastName(person.getLastName());
    		model.setDateOfBirth(person.getLocalBirthDate());
    		model.setId(person.getId());
    		model.setStores(person.getStores());
    	}
    	
    	personService.savePerson(model);
    	log.debug("Person id " + model.getId() + " has been saved.");
    	
    	return "redirect:/people/index";
    }
    
    @RequestMapping(value = "/delete/{id}",
    		method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id){
    	ModelAndView mav = new ModelAndView("/people/delete");
     	mav.addObject("person", personService.getPersonByID(id));
    	return mav;
    }    
    
    @RequestMapping(value = "/delete/{id}",
    		method = RequestMethod.POST)
    public String deleteConfirm(@PathVariable int id){
    	personService.deletePerson(id);
    	log.debug("Deleted person.");
    	
    	return "redirect:/people/index";
    }
}
