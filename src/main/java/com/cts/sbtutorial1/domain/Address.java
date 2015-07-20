package com.cts.sbtutorial1.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Address")
public class Address {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "addressLine1", length = 50, nullable = false)
    private String addressLine1;
    
    @Size(min = 0, max = 50)
    @Column(name = "addressLine2", length = 50, nullable = false)
    private String addressLine2;
    
    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "city", length = 50, nullable = false)
    private String city;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "state", length = 50, nullable = false)
    private String state;

    @NotNull
    @Size(min = 3, max = 10)
    @Column(name = "postal_code", length = 10, nullable = false)
    private String postalCode;

    @OneToOne(mappedBy = "address")
    @JsonIgnore
    private Store store;
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
    public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}
}
