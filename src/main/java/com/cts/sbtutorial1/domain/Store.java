package com.cts.sbtutorial1.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import javax.persistence.CascadeType;

@Entity
@Table(name = "Store")
public class Store implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3808229980883154027L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "name", length = 50, nullable = false)
    private String name;

	@OneToOne
    private Address address;

    @OneToMany(mappedBy = "store")
    private Set<Product> products;
    
    @ManyToMany(cascade=CascadeType.ALL, mappedBy="stores")
    private Set<Person> owners = new HashSet<Person>();
    
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
    
    public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Set<Person> getOwners() {
		return owners;
	}

	public void setOwners(Set<Person> owners) {
		this.owners = owners;
	}
	
	@Override
	public String toString(){
		return name;
	}
}
