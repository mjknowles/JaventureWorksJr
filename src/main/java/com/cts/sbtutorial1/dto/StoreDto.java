package com.cts.sbtutorial1.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import com.cts.sbtutorial1.domain.Address;

@Component
public class StoreDto {
	
    private Integer id;
    
    @NotNull
    @Size(min = 2, max = 50)
    private String name;

    private Address address;
    
    private Integer personId;
    
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
    
	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	@Override
	public String toString(){
		return name;
	}

}
