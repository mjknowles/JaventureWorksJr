package com.cts.sbtutorial1.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "users")
public class UserDao implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -5843443004013520432L;

	@Id
	@NotNull
    @Size(min = 2, max = 50)
    @Column(name = "username")
    private String userName;
    
	
	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	@Override
	public String toString(){
		String stringOut = userName;
		return stringOut;
	}
}
