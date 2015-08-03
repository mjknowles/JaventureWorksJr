package com.cts.sbtutorial1.controllers;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cts.sbtutorial1.services.UserService;

@RequestMapping("/user")
@Controller
public class UserController {
 
	private final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Inject
	private UserService userService;
	
    @RequestMapping(value={"/", "", "/index"})
    public ModelAndView index(){
    	ModelAndView mav = new ModelAndView("/user/index");
    	
    	mav.addObject("users", userService.getAllUsers());
    	
    	return mav;
    }
    
    @RequestMapping(value={"delete/{username}"})
    public ModelAndView deleteUser(@PathVariable("username") String username){
    	ModelAndView mav = new ModelAndView("redirect:/user");
    	
    	if(userService.checkIfExists(username)){
    		userService.deleteUser(username);
    	}
    	else{
    		mav = new ModelAndView("redirect:/user?nope");
    	}
    	
    	mav.addObject("users", userService.getAllUsers());
    	
    	return mav;
    }
   
}
