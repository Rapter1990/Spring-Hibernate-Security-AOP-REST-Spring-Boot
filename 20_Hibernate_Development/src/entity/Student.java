package entity;

import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="STUDENT",catalog = "SPRINGDATABASE")
@NamedQueries({
	@NamedQuery(name = "Student.findAll",query = "SELECT s FROM Student s ORDER BY s.id ASC"),
	@NamedQuery(name = "Student.countAll",query = "SELECT COUNT(*) FROM Student s")
})
public class Student {

	@Id
	@SequenceGenerator(name="STUDENT_SEQ", sequenceName="STUDENT_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="STUDENT_SEQ")
	@Column(name="ID", nullable = false)
	private int id;
	
	@Column(name="FIRSTNAME")
	private String firstName;
	
	@Column(name="LASTNAME")
	private String lastName;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="IMAGE")
	private byte[] image;
	
	@Temporal(TemporalType.DATE)
	@Column(name="REGISTERDATE")
	private Date registerDate;
	
	@Transient
	private String base64Image;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "pk.course")
	private Set<CourseStudent> courses = new HashSet<CourseStudent>();

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int id) {
		super();
		this.id = id;
	}

	
	public Student(String firstName, String lastName, String email, byte[] image, Date registerDate,
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

	public String getBase64Image() {
		base64Image = Base64.getEncoder().encodeToString(this.image);
		return base64Image;
	}

	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}
	
	
	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	

	public Set<CourseStudent> getCourses() {
		return courses;
	}

	public void setCourses(Set<CourseStudent> courses) {
		this.courses = courses;
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
		Student other = (Student) obj;
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
		return true;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", image=" + Arrays.toString(image) + ", base64Image=" + base64Image + "]";
	}

	
	
	
}
