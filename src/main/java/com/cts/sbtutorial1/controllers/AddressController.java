package com.cts.sbtutorial1.controllers;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cts.sbtutorial1.domain.Address;
import com.cts.sbtutorial1.dto.AddressDto;
import com.cts.sbtutorial1.services.AddressService;


@Controller
public class AddressController {
	private final Logger log = LoggerFactory.getLogger(AddressController.class);
	
	@Inject
	private AddressService addressService;
	
	
    @RequestMapping("/address")
    public ModelAndView addressIndex(){
    	ModelAndView mav = new ModelAndView("/address/index");
    	log.debug("Request to get all addresses.");
    	mav.addObject("addresses",addressService.getAllAddresses());
    	log.debug("Got all addresses.");
    	
    	return mav;
    }
    
    @RequestMapping("/address/save")
    public ModelAndView addressSave(AddressDto address){
    	ModelAndView mav = new ModelAndView("/address/create");
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
    	mav.addObject("address", address);
    	
    	return mav;
    }
    
    @RequestMapping("/address/form")
    public ModelAndView addressCreateForm(AddressDto address){
    	ModelAndView mav = new ModelAndView("/address/create");
    	
    	if(address == null){
    		address = new AddressDto();
    	}
    	
    	mav.addObject("address", address);
    	
    	return mav;
    }
}
