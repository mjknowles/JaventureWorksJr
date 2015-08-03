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
import com.cts.sbtutorial1.domain.Product;
import com.cts.sbtutorial1.dto.AddressDto;
import com.cts.sbtutorial1.dto.ProductDto;
import com.cts.sbtutorial1.services.ProductService;


@Controller
@RequestMapping("/products")
public class ProductsController {
	private final Logger log = LoggerFactory.getLogger(ProductsController.class);
	
	@Inject
	private ProductService productService;
	
	
    @RequestMapping(value = {"/", "", "/index"})
    public ModelAndView productIndex(){
    	ModelAndView mav = new ModelAndView("/products/index");
    	mav.addObject("products",productService.getAllProducts());
    	log.debug("Got all products.");
    	
    	return mav;
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView productCreateForm(){
    	ModelAndView mav = new ModelAndView("/products/create");
    	mav.addObject("product", new ProductDto());
    	
    	return mav;
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(ProductDto product){
    	Product model = new Product();
    	
    	if(product != null){
    		model.setDescription(product.getDescription());
    		model.setId(product.getId());
    		model.setImageUrl(product.getImageUrl());
    		model.setName(product.getName());
    		model.setPrice(product.getPrice());
    		model.setProductId(product.getProductId());
    		model.setStore(product.getStore());
    	}
    	
    	productService.saveProduct(model);
    	log.debug("Product id " + product.getId() + " has been saved.");
    	product.setId(model.getId());
    	
    	return "redirect:/products/index";
    }
    
    @RequestMapping(value = "/edit/{id}",
    		method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable int id){
    	ModelAndView mav = new ModelAndView("/products/edit");
     	mav.addObject("product", productService.getProductByID(id));
    	return mav;
    }    
    
    @RequestMapping(value = "/edit/{id}",
    		method = RequestMethod.POST)
    public String edit(ProductDto product){
    	Product model = new Product();
    	log.debug("Saving product.");
    	
    	if(product != null){
    		model.setDescription(product.getDescription());
    		model.setId(product.getId());
    		model.setImageUrl(product.getImageUrl());
    		model.setName(product.getName());
    		model.setPrice(product.getPrice());
    		model.setProductId(product.getProductId());
    		model.setStore(product.getStore());
    	}
    	
    	productService.saveProduct(model);
    	log.debug("Product id " + model.getId() + " has been saved.");
    	
    	return "redirect:/products/index";
    }
    
    @RequestMapping(value = "/delete/{id}",
    		method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id){
    	ModelAndView mav = new ModelAndView("/products/delete");
     	mav.addObject("product", productService.getProductByID(id));
    	return mav;
    }    
    
    @RequestMapping(value = "/delete/{id}",
    		method = RequestMethod.POST)
    public String deleteConfirm(@PathVariable int id){
    	productService.deleteProduct(id);
    	log.debug("Deleted products.");
    	
    	return "redirect:/products/index";
    }
}
