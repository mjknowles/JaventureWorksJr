package com.cts.sbtutorial1.dto;

import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import com.cts.sbtutorial1.domain.Address;
import com.cts.sbtutorial1.domain.Person;

@Component
public class StoreDto {
	
    private Integer id;
    
    @NotNull
    @Size(min = 2, max = 50)
    private String name;

    private Address address;
        
    private List<Person> owners;
    
	public List<Person> getOwners() {
		return owners;
	}

	public void setOwners(List<Person> owners) {
		this.owners = owners;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString(){
		return name;
	}

}
