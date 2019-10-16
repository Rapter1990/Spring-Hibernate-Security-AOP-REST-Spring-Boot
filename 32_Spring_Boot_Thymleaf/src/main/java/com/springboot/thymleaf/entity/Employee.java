package com.springboot.thymleaf.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="EMPLOYEE",catalog = "SPRINGDATABASE")
public class Employee implements Serializable{

	@Id
	@SequenceGenerator(name="EMPLOYEE_SEQ", sequenceName="EMPLOYEE_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EMPLOYEE_SEQ")
	@Column(name="ID", nullable = false)
	private int id;
	
	@NotNull(message="is required")
	@Column(name="FIRSTNAME")
	private String firstName;
	
	@NotNull(message="is required")
	@Column(name="LASTNAME")
	private String lastName;
	
	@NotNull(message="is required")
	@Column(name="EMAIL")
	private String email;
	
	@NotNull(message="is required")
	@Column(name="IMAGE")
	private byte[] image;
	
	@NotNull(message="is required")
	@Temporal(TemporalType.DATE)
	@Column(name="REGISTER_DATE")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date registerDate;
	
	@Transient
	private String base64Image;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Employee(int id) {
		super();
		this.id = id;
	}


	public Employee(@NotNull(message = "is required") String firstName,
			@NotNull(message = "is required") String lastName, @NotNull(message = "is required") String email,
			@NotNull(message = "is required") byte[] image, @NotNull(message = "is required") Date registerDate,
			String base64Image) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.image = image;
		this.registerDate = registerDate;
		this.base64Image = base64Image;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public byte[] getImage() {
		return image;
	}


	public void setImage(byte[] image) {
		this.image = image;
	}


	public Date getRegisterDate() {
		return registerDate;
	}


	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}


	public String getBase64Image() {
		base64Image = Base64.getEncoder().encodeToString(this.image);
		return base64Image;
	}


	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", image=" + Arrays.toString(image) + ", registerDate=" + registerDate + ", base64Image="
				+ base64Image + "]";
	}
	
	
	
}
