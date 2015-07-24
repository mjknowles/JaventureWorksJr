package com.cts.sbtutorial1.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;
    
    @NotNull
    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;
    
    @ManyToMany
    @JoinTable(name = "Owner_Store",
    	joinColumns = @JoinColumn(name="persons_id", referencedColumnName="ID"),
    	inverseJoinColumns = @JoinColumn(name="stores_id", referencedColumnName="ID"))
    private Set<Store> stores = new HashSet<Store>();
    
    public Set<Store> getStores()  
    {  
        return stores;  
    }
    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setStores(Set<Store> stores)  
    {  
        this.stores = stores;  
    } 	
	
	@Override
	public String toString(){
		return firstName + " " + lastName;
	}
	
}
