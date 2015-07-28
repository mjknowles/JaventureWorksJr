package com.cts.sbtutorial1.services;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cts.sbtutorial1.domain.Product;
import com.cts.sbtutorial1.repositories.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

	private final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	
	@Inject
	private ProductRepository productRepository;
	
	@Override
	public void deleteProduct(int id) {
		log.debug("Service request to delete a product.");
		productRepository.delete(id);		
	}

	@Override
	public void saveProduct(Product product) {
		log.debug("Service request to save a product.");
		productRepository.save(product);
	}

	@Override
	public Product getProductByID(int id) {
		log.debug("Service request to get a product by ID.");
		return productRepository.findOne(id);
	}

	@Override
	public List<Product> getAllProducts() {
		log.debug("Service request to get all products.");
		return productRepository.findAll();
	}

}
