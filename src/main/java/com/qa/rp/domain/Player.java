package com.qa.rp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Player {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO_INCREMENT
	private Integer id;
		
	private String firstname;
	private String lastname;
	private String emailaddress;

	
	
	public Player(Integer id, String firstname, String lastname, String emailaddress) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.emailaddress = emailaddress;
	}
		
	public Player(String firstname, String lastname, String emailaddress) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.emailaddress = emailaddress;
	}
	
	public Player() {
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmailaddress() {
		return emailaddress;
	}
	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}



	
	
	
	
	
	
	
	
	
}