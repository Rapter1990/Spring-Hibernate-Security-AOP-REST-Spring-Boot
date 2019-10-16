package com.crud.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="CUSTOMER",catalog = "SPRINGDATABASE")
@NamedQueries({
	@NamedQuery(name = "Customer.findAll",query = "SELECT c FROM Customer c ORDER BY c.id ASC"),
	@NamedQuery(name = "Customer.countAll",query = "SELECT COUNT(*) FROM Customer c"),
	@NamedQuery(name = "Customer.search", 
	query = "SELECT c FROM Customer c WHERE LOWER(c.firstName) LIKE :theName OR LOWER(c.lastName) LIKE :theName"
			+ " OR LOWER(c.email) LIKE :theName")
})
public class Customer implements Serializable{

	@Id
	@SequenceGenerator(name="CUSTOMER_SEQ", sequenceName="CUSTOMER_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CUSTOMER_SEQ")
	@Column(name="ID", nullable = false)
	private int id;
	
	@NotNull(message="is required")
	@Column(name="FIRSTNAME")
	private String firstName;
	
	@NotNull(message="is required")
	@Column(name="LASTNAME")
	private String lastName;
	
	@NotNull(message="is required")
	//@Pattern(regexp="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$", message="valid email required")
	@Column(name="EMAIL")
	private String email;
	
	@NotNull(message="is required")
	@Column(name="IMAGE")
	private byte[] image;
	
	@NotNull(message="is required")
	@Temporal(TemporalType.DATE)
	@Column(name="REGISTER_DATE")
	private Date registerDate;
	
	@Transient
	private String base64Image;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int id) {
		super();
		this.id = id;
	}

	public Customer(String firstName, String lastName, String email, Date registerDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.registerDate = registerDate;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((base64Image == null) ? 0 : base64Image.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + Arrays.hashCode(image);
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((registerDate == null) ? 0 : registerDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (base64Image == null) {
			if (other.base64Image != null)
				return false;
		} else if (!base64Image.equals(other.base64Image))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (!Arrays.equals(image, other.image))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (registerDate == null) {
			if (other.registerDate != null)
				return false;
		} else if (!registerDate.equals(other.registerDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", image=" + Arrays.toString(image) + ", registerDate=" + registerDate + ", base64Image="
				+ base64Image + "]";
	}
	
	
	
}
