package entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="COURSE",catalog = "SPRINGDATABASE")
@NamedQueries({
	@NamedQuery(name = "Course.findAll",query = "SELECT c FROM Course c ORDER BY c.id ASC"),
	@NamedQuery(name = "Course.countAll",query = "SELECT COUNT(*) FROM Course c"),
	@NamedQuery(name = "Course.findByInstructor",
	            query = "SELECT c.id FROM Course c LEFT JOIN Instructor i ON c.instructor.id = i.id")
})
public class Course {

	@Id
	@SequenceGenerator(name="COURSE_SEQ", sequenceName="COURSE_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COURSE_SEQ")
	@Column(name="ID", nullable = false)
	private int id;
	
	@Column(name="TITLE")
	private String title;
	
	@ManyToOne(fetch=FetchType.LAZY,cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name = "INSTRUCTOR_ID", nullable = false)
	private Instructor instructor;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="course")
	private Set<Review> reviews = new HashSet<Review>();
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="pk.student")
	private Set<CourseStudent> students = new HashSet<CourseStudent>();

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(int id) {
		super();
		this.id = id;
	}
	
	
	public Course(String title) {
		super();
		this.title = title;
	}

	public Course(String title, Instructor instructor) {
		super();
		this.title = title;
		this.instructor = instructor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	

	public Set<Review> getReviews() {
		return reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}

	
	public Set<CourseStudent> getStudents() {
		return students;
	}

	public void setStudents(Set<CourseStudent> students) {
		this.students = students;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((instructor == null) ? 0 : instructor.hashCode());
		result = prime * result + ((reviews == null) ? 0 : reviews.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Course other = (Course) obj;
		if (id != other.id)
			return false;
		if (instructor == null) {
			if (other.instructor != null)
				return false;
		} else if (!instructor.equals(other.instructor))
			return false;
		if (reviews == null) {
			if (other.reviews != null)
				return false;
		} else if (!reviews.equals(other.reviews))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", instructor=" + instructor + ", reviews=" + reviews + "]";
	}
	
	
}
