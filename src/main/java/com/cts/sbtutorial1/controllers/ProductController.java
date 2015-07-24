package com.cts.sbtutorial1.controllers;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cts.sbtutorial1.domain.Product;
import com.cts.sbtutorial1.dto.ProductDto;
import com.cts.sbtutorial1.services.ProductService;


@Controller
public class ProductController {
	private final Logger log = LoggerFactory.getLogger(ProductController.class);
	
	@Inject
	private ProductService productService;
	
	
    @RequestMapping("/product")
    public ModelAndView productIndex(){
    	ModelAndView mav = new ModelAndView("/product/index");
    	mav.addObject("products",productService.getAllProducts());
    	log.debug("Got all products.");
    	
    	return mav;
    }
    
    @RequestMapping("/product/save")
    public ModelAndView productSave(ProductDto product){
    	ModelAndView mav = new ModelAndView("/product/create");
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
    	
    	mav.addObject("product", product);
    	
    	return mav;
    }
    
    @RequestMapping("/product/form")
    public ModelAndView productCreateForm(Product product){
    	ModelAndView mav = new ModelAndView("/product/create");
    	if(product == null){
    		product = new Product();
    	}
    	
    	mav.addObject("product", product);
    	
    	return mav;
    }
}
