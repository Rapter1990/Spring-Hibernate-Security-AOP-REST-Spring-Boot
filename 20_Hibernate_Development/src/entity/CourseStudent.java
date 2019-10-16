package entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Column;

@Entity
@Table(name = "COURSE_STUDENT", catalog = "JSPPROJECTDATABASE")
@NamedQueries({
	@NamedQuery(name = "CourseStudent.findAll", 
			query = "SELECT cs FROM CourseStudent cs"),
	@NamedQuery(name = "CourseStudent.countByCourse",
				query = "SELECT COUNT(*) FROM CourseStudent cs WHERE cs.course.id =:courseId"),
	@NamedQuery(name = "CourseStudent.studentWithCourse",
				query = "SELECT cs FROM CourseStudent cs WHERE cs.course.id =:courseId AND cs.student.id =:studentId"),
	@NamedQuery(name = "CourseStudent.studentsByCourse",
				query = "SELECT cs FROM CourseStudent cs WHERE cs.course.id =:courseId"),
	@NamedQuery(name = "CourseStudent.deleteObjectwithStudentIdAndCourseId",
				query = "DELETE FROM CourseStudent cs WHERE cs.course.id =:courseId AND cs.student.id =:studentId")
	
})
public class CourseStudent {

	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "COURSE_ID", column = @Column(name = "ID", nullable = false)),
		@AttributeOverride(name = "STUDENT_ID", column = @Column(name = "ID", nullable = false))})
	private CourseStudentId pk = new CourseStudentId();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COURSE_ID", insertable = false, updatable = false, nullable = false)
	private Course course;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STUDENT_ID", insertable = false, updatable = false, nullable = false)
	private Student student;

	public CourseStudent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CourseStudentId getPk() {
		return pk;
	}

	public void setPk(CourseStudentId pk) {
		this.pk = pk;
	}

	@Transient
	public Course getCourse() {
		return getPk().getCourse();
	}

	public void setCourse(Course course) {
		getPk().setCourse(course);
	}

	@Transient
	public Student getStudent() {
		return getPk().getStudent();
	}

	public void setStudent(Student student) {
		getPk().setStudent(student);
	}
	
	
	
}
