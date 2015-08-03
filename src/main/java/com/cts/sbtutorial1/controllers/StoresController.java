package com.cts.sbtutorial1.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import com.cts.sbtutorial1.dto.StoreDto;
import com.cts.sbtutorial1.services.AddressService;
import com.cts.sbtutorial1.services.PersonService;
import com.cts.sbtutorial1.services.StoreService;


@Controller
@RequestMapping("/stores")
public class StoresController {
	private final Logger log = LoggerFactory.getLogger(StoresController.class);
	
	@Inject
	private StoreService storeService;
	@Inject
	private AddressService addressService;
	@Inject
	private PersonService personService;
	
    @RequestMapping(value = {"/", "", "/index"})	
    public ModelAndView index(){
    	ModelAndView mav = new ModelAndView("/stores/index");
    	log.debug("Request to get all stores.");
    	mav.addObject("stores",storeService.getAllStores());
    	log.debug("Got all stores.");
    	
    	return mav;
    }

    @RequestMapping("/create")
    public ModelAndView create(){
    	ModelAndView mav = new ModelAndView("/stores/create");
    	    	
    	mav.addObject("store", new StoreDto());
    	mav.addObject("addresses", addressService.getAllAddresses());
    	mav.addObject("allOwners", personService.getAllPeople());
    	    	
    	return mav;
    }
    
    @RequestMapping(value = "/create",
    		method = RequestMethod.POST)
    public String create(StoreDto store){
    	Store model = new Store();
    	log.debug("Saving store.");
    	
    	if(store != null){
    		model.setAddress(store.getAddress());
    		model.setName(store.getName());
    		model.setOwners(new HashSet<Person>(store.getOwners()));
    		//model.setProducts(store.getProducts());
    	}
    	
    	storeService.saveStore(model);
    	
    	if(store.getOwners() != null)
    	{
			for(Person person : store.getOwners())
			{
				person.addStore(model);
				personService.savePerson(person);
			}
    	}    	
  
    	log.debug("Store id " + model.getId() + " has been saved.");
    	
    	return "redirect:/stores/index";
    }

    @RequestMapping(value = "/edit/{id}",
    		method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable int id){
    	ModelAndView mav = new ModelAndView("/stores/edit");
     	mav.addObject("store", storeService.getStoreByID(id));
    	mav.addObject("addresses", addressService.getAllAddresses());
    	mav.addObject("allOwners", personService.getAllPeople());

    	return mav;
    }    
    
    @RequestMapping(value = "/edit/{id}",
    		method = RequestMethod.POST)
    public String edit(StoreDto store){
    	Store model = new Store();
    	log.debug("Saving store.");
    	
    	if(store != null){
    		model.setAddress(store.getAddress());
    		model.setName(store.getName());
    		model.setId(store.getId());
    	}
    	
    	storeService.saveStore(model);

    	log.debug("Store id " + model.getId() + " has been saved.");
    	
    	return "redirect:/stores/index";
    }
    
    @RequestMapping(value = "/delete/{id}",
    		method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id){
    	ModelAndView mav = new ModelAndView("/stores/delete");
     	mav.addObject("store", storeService.getStoreByID(id));
    	return mav;
    }    
    
    @RequestMapping(value = "/delete/{id}",
    		method = RequestMethod.POST)
    public String deleteConfirm(@PathVariable int id){
    	storeService.deleteStore(id);
    	log.debug("Deleted store.");
    	
    	return "redirect:/stores/index";
    }
}
