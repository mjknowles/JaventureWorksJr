package com.cts.sbtutorial1.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.cts.sbtutorial1.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{
	public List<Product> findAll();
}
