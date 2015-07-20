package com.cts.sbtutorial1.repositories;

import org.springframework.data.repository.CrudRepository;
import com.cts.sbtutorial1.domain.Address;

public interface AddressRepository extends CrudRepository<Address, Integer>{

}
