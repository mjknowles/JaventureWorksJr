package com.cts.sbtutorial1.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cts.sbtutorial1.domain.Store;

public interface StoreRepository extends CrudRepository<Store, Integer>{
	public List<Store> findAll();
}
