package entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="REVIEW",catalog = "SPRINGDATABASE")
@NamedQueries({
	@NamedQuery(name = "Review.findAll",query = "SELECT r FROM Review r ORDER BY r.id ASC"),
	@NamedQuery(name = "Review.countAll",query = "SELECT COUNT(*) FROM Review r"),
	@NamedQuery(name = "Review.countByCourse",
	            query = "SELECT COUNT(r.id) FROM Review r WHERE r.course.id =:courseId"),
	@NamedQuery(name = "Review.findByCourse",
    query = "SELECT r FROM Review r LEFT JOIN Course c ON r.course.id = :courseId")
})
public class Review {

	@Id
	@SequenceGenerator(name="REVIEW_SEQ", sequenceName="REVIEW_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="REVIEW_SEQ")
	@Column(name="ID", nullable = false)
	private int id;
	
	@Column(name="COMMENTS")
	private String comment;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "COURSE_ID", nullable = false)
	private Course course;

	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Review(int id) {
		super();
		this.id = id;
	}

	public Review(String comment) {
		super();
		this.comment = comment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		result = prime * result + id;
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
		Review other = (Review) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (course == null) {
			if (other.course != null)
				return false;
		} else if (!course.equals(other.course))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", comment=" + comment + ", course=" + course + "]";
	}
	
	
}
