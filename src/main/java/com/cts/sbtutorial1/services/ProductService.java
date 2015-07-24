package com.cts.sbtutorial1.services;

import java.util.List;

import com.cts.sbtutorial1.domain.Product;

public interface ProductService {
	public void deleteProduct(int id);
	public void saveProduct(Product product);
	public Product getProductByID(int id);
	public List<Product> getAllProducts();
}
