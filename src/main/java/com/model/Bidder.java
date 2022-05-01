package com.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Bidder {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int bidderId;
	@NotNull
	private String userName;
	
	@NotNull
	private String password;
	
	@NotNull
	private String Name;

	@NotNull
	private String email;

	@NotNull
	private String phoneNo;
	
	@OneToMany
	private List<Bid> bidlist;
	
	public Bidder() {}

	public int getBidderId() {
		return bidderId;
	}

	public void setBidderId(int bidderId) {
		this.bidderId = bidderId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public List<Bid> getBidlist() {
		return bidlist;
	}

	public void setBidlist(List<Bid> bidlist) {
		this.bidlist = bidlist;
	}
	
	
}
