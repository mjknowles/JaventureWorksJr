package com.cts.sbtutorial1.controllers;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cts.sbtutorial1.domain.Address;
import com.cts.sbtutorial1.domain.Store;
import com.cts.sbtutorial1.dto.StoreDto;
import com.cts.sbtutorial1.services.AddressService;
import com.cts.sbtutorial1.services.StoreService;


@Controller
public class StoreController {
	private final Logger log = LoggerFactory.getLogger(StoreController.class);
	
	@Inject
	private StoreService storeService;
	@Inject
	private AddressService addressService;
	
	
    @RequestMapping("/store")
    public ModelAndView storeIndex(){
    	ModelAndView mav = new ModelAndView("/store/index");
    	log.debug("Request to get all addresses.");
    	mav.addObject("stores",storeService.getAllStores());
    	log.debug("Got all stores.");
    	
    	return mav;
    }
    
    @RequestMapping("/store/save")
    public ModelAndView storeSave(StoreDto store){
    	ModelAndView mav = new ModelAndView("/store/create");
    	Store model = new Store();
    	
    	if(store != null){
    		if(store.getAddress().getId() != null){
    			model.setAddress(addressService.getAddressByID(store.getAddress().getId()));
    		}
    		else{
    			model.setAddress(new Address());
    		}
    		model.setId(store.getId());
    		model.setName(store.getName());
    	}
    	
    	storeService.saveStore(model);
    	log.debug("Store id " + store.getId() + " has been saved.");
    	mav.addObject("store", store);
    	mav.addObject("addresses", addressService.getAllAddresses());
    	
    	return mav;
    }
    
    @RequestMapping("/store/form")
    public ModelAndView storeCreateForm(StoreDto store){
    	ModelAndView mav = new ModelAndView("/store/create");
    	
    	if(store == null){
    		store = new StoreDto();
    		store.setAddress(new Address());
    	}
    	
    	mav.addObject("store", store);
    	mav.addObject("addresses", addressService.getAllAddresses());
    	
    	return mav;
    }
}
