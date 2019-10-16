package entity;

import java.util.Arrays;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="INSTRUCTOR",catalog = "SPRINGDATABASE")
@NamedQueries({
	@NamedQuery(name = "Instructor.findAll",query = "SELECT i FROM Instructor i ORDER BY i.id ASC"),
	@NamedQuery(name = "Instructor.countAll",query = "SELECT COUNT(*) FROM Instructor i")
})
public class Instructor {

	@Id
	@SequenceGenerator(name="INSTRUCTOR_SEQ", sequenceName="INSTRUCTOR_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INSTRUCTOR_SEQ")
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
	
	@Transient
	private String base64Image;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="INSTRUCTORDETAIL_ID")
	private InstructorDetail instructorDetail;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="instructor",
			   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH})
	private Set<Course> courses = new HashSet<Course>();

	public Instructor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Instructor(int id) {
		super();
		this.id = id;
	}

	
	public Instructor(int id, String firstName, String lastName, String email, byte[] image, String base64Image,
			InstructorDetail instructorDetail) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.image = image;
		this.base64Image = base64Image;
		this.instructorDetail = instructorDetail;
	}
	
	

	public Instructor(String firstName, String lastName, String email, byte[] image, String base64Image,
			InstructorDetail instructorDetail, Set<Course> courses) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.image = image;
		this.base64Image = base64Image;
		this.instructorDetail = instructorDetail;
		this.courses = courses;
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

	public InstructorDetail getInstructorDetail() {
		return instructorDetail;
	}

	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}
	
	
	public String getBase64Image() {
		base64Image = Base64.getEncoder().encodeToString(this.image);
		return base64Image;
	}

	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}
	
	

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((base64Image == null) ? 0 : base64Image.hashCode());
		result = prime * result + ((courses == null) ? 0 : courses.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + Arrays.hashCode(image);
		result = prime * result + ((instructorDetail == null) ? 0 : instructorDetail.hashCode());
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
		Instructor other = (Instructor) obj;
		if (base64Image == null) {
			if (other.base64Image != null)
				return false;
		} else if (!base64Image.equals(other.base64Image))
			return false;
		if (courses == null) {
			if (other.courses != null)
				return false;
		} else if (!courses.equals(other.courses))
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
		if (instructorDetail == null) {
			if (other.instructorDetail != null)
				return false;
		} else if (!instructorDetail.equals(other.instructorDetail))
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
		return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", image=" + Arrays.toString(image) + ", base64Image=" + base64Image + ", instructorDetail="
				+ instructorDetail + ", courses=" + courses + "]";
	}
	

}
