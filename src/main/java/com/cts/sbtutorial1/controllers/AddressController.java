package com.cts.sbtutorial1.controllers;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cts.sbtutorial1.domain.Address;
import com.cts.sbtutorial1.dto.AddressDto;
import com.cts.sbtutorial1.services.AddressService;


@Controller
@RequestMapping("/addresses")
public class AddressController {
	private final Logger log = LoggerFactory.getLogger(AddressController.class);
	
	@Inject
	private AddressService addressService;
	
	
    @RequestMapping(value = {"/", "", "/index"})
    public ModelAndView index(){
    	ModelAndView mav = new ModelAndView("/address/index");
    	log.debug("Request to get all addresses.");
    	mav.addObject("addresses",addressService.getAllAddresses());
    	log.debug("Got all addresses.");
    	
    	return mav;
    }
    
    @RequestMapping(value = "/create",
    		method = RequestMethod.GET)
    public ModelAndView create(){
    	ModelAndView mav = new ModelAndView("/address/create");
     	mav.addObject("address", new AddressDto());
    	return mav;
    }
    
    @RequestMapping(value = "/create",
    		method = RequestMethod.POST)
    public String create(AddressDto address){
    	Address model = new Address();
    	log.debug("Saving address.");
    	
    	if(address != null){
    		model.setAddressLine1(address.getAddressLine1());
    		model.setAddressLine2(address.getAddressLine2());
    		model.setId(address.getId());
    		model.setState(address.getState());
    		model.setPostalCode(address.getPostalCode());
    		model.setCity(address.getCity());
    	}
    	
    	addressService.saveAddress(model);
    	address.setId(model.getId());
    	log.debug("Address id " + model.getId() + " has been saved.");
    	
    	return "redirect:/addresses/index";
    }

    @RequestMapping(value = "/edit/{id}",
    		method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable int id){
    	ModelAndView mav = new ModelAndView("/address/edit");
     	mav.addObject("address", addressService.getAddressByID(id));
    	return mav;
    }    
    
    @RequestMapping(value = "/edit/{id}",
    		method = RequestMethod.POST)
    public String edit(AddressDto address){
    	Address model = new Address();
    	log.debug("Saving address.");
    	
    	if(address != null){
    		model.setAddressLine1(address.getAddressLine1());
    		model.setAddressLine2(address.getAddressLine2());
    		model.setId(address.getId());
    		model.setState(address.getState());
    		model.setPostalCode(address.getPostalCode());
    		model.setCity(address.getCity());
    	}
    	
    	addressService.saveAddress(model);
    	address.setId(model.getId());
    	log.debug("Address id " + model.getId() + " has been saved.");
    	
    	return "redirect:/addresses/index";
    }
    
    @RequestMapping(value = "/delete/{id}",
    		method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id){
    	ModelAndView mav = new ModelAndView("/address/delete");
     	mav.addObject("address", addressService.getAddressByID(id));
    	return mav;
    }    
    
    @RequestMapping(value = "/delete/{id}",
    		method = RequestMethod.POST)
    public String deleteConfirm(@PathVariable int id){
    	addressService.deleteAddress(id);
    	log.debug("Deleted address.");
    	
    	return "redirect:/addresses/index";
    }
}
