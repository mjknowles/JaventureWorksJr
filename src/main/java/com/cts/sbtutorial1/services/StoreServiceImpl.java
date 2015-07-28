package com.cts.sbtutorial1.services;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cts.sbtutorial1.domain.Store;
import com.cts.sbtutorial1.repositories.StoreRepository;

@Service
@Transactional
public class StoreServiceImpl implements StoreService {

	private final Logger log = LoggerFactory.getLogger(StoreServiceImpl.class);
	
	@Inject
	private StoreRepository storeRepository;
	
	@Override
	public void deleteStore(int id) {
		log.debug("Service request to delete a store.");
		storeRepository.delete(id);
	}

	@Override
	public void saveStore(Store store) {
		log.debug("Service request to save a store.");
		storeRepository.save(store);
	}

	@Override
	public Store getStoreByID(int id) {
		log.debug("Service request to get a store by ID.");
		return storeRepository.findOne(id);
	}

	@Override
	public List<Store> getAllStores() {
		log.debug("Service request to get all stores.");
		return storeRepository.findAll();
	}

}
