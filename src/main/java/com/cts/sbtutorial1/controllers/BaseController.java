package com.cts.sbtutorial1.controllers;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

public class BaseController {
	@InitBinder
	public void binder(WebDataBinder binder){
		binder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
		    public void setAsText(String value) {
		        try {
		            setValue(new SimpleDateFormat("MM/dd/yyyy").parse(value));
		        } catch(ParseException e) {
		            setValue(null);
		        }
		    }

		    public String getAsText() {
		    	if(getValue() == null){
		    		return "";
		    	}
		        	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		        	LocalDate date = (LocalDate)getValue();
					return date.format(formatter);
		    }        

		});
	}
}
