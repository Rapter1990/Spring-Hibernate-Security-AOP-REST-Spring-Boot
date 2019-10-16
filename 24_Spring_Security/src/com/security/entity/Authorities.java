package com.security.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="AUTHORITIES",catalog = "SPRINGDATABASE")
public class Authorities implements Serializable{

	@Id
	@SequenceGenerator(name="AUTHORITIES_SEQ", sequenceName="AUTHORITIES_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AUTHORITIES_SEQ")
	@Column(name="ID", nullable = false)
	private int id;
	
	@Column(name = "AUTHORITY")
	private String authority; 
	
	@ManyToOne(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "USERNAME", nullable = false)
	private User user;

	public Authorities() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Authorities(int id, String authority, User user) {
		super();
		this.id = id;
		this.authority = authority;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "Authorities [id=" + id + ", authority=" + authority + ", user=" + user + "]";
	}
	
	
	
}
