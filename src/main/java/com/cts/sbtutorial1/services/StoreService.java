package com.cts.sbtutorial1.services;

import java.util.List;

import com.cts.sbtutorial1.domain.Store;

public interface StoreService {
	public void deleteStore(int id);
	public void saveStore(Store store);
	public Store getStoreByID(int id);
	public List<Store> getAllStores();
}
