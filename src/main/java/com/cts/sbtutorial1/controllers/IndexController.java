package com.cts.sbtutorial1.controllers;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cts.sbtutorial1.services.UserService;
 
@Controller
public class IndexController {
 
	private final Logger log = LoggerFactory.getLogger(IndexController.class);
	
	@Inject
	private UserService userService;
	
    @RequestMapping("/")
    String index(){
    	return "/home/index";
    }
    
    @RequestMapping("/login")
    public ModelAndView guestLogin(){
    	ModelAndView mav = new ModelAndView("/home/login");
    	return mav;
    }
    
    
    @RequestMapping("/register")
    public ModelAndView guestRegister(String username, String password){
    	ModelAndView mav = new ModelAndView("redirect:/login");
    	userService.setDataSource();
    	
    	if(!userService.checkIfExists(username)){
    		userService.createUser(username, password);
    		return mav;
    	}
    	
    	mav = new ModelAndView("redirect:/?error");
    	return mav;
    }
   
}
