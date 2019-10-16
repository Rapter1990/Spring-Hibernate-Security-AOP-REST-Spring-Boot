package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Rule;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import dao.CourseDao;
import dao.CourseStudentDao;
import dao.InstructorDao;
import dao.StudentDao;
import entity.Course;
import entity.CourseStudent;
import entity.Instructor;
import entity.InstructorDetail;
import entity.Student;


class CourseStudentTest {

	static CourseStudentDao courseStudentDao = null;
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@BeforeAll
	public static void setUpClass() {
		System.out.println("setUpClass");

		courseStudentDao = new CourseStudentDao();
	}
	
	@Test
	void testCreateCourseStudent() {
		
		Course newCourse = new Course();
		newCourse.setId(15);
		
		Student newStudent = new Student();
		newStudent.setId(2);
		
		CourseStudent courseStudent = new CourseStudent();
		courseStudent.setCourse(newCourse);
		courseStudent.setStudent(newStudent);
		
		CourseStudent createdCourseStudent = courseStudentDao.create(courseStudent);
		assertNotNull(createdCourseStudent); 
	}
	
	@Test
	void testGetCourseById() {
		
		System.out.println("testGetCourseById");
		Integer id = 15;
		
		List<CourseStudent> courseStudents = courseStudentDao.listStudentsWithCourse(id);
		for(CourseStudent courseStudent : courseStudents) {
			System.out.println("--------------------------------------------------------------");
			System.out.println("Course Id : " + courseStudent.getCourse().getTitle());
			System.out.println("Student FirstName : " + courseStudent.getStudent().getFirstName());
			System.out.println("Student LastName : " + courseStudent.getStudent().getLastName());
			System.out.println("Student Email : " + courseStudent.getStudent().getEmail());
			System.out.println("Student Register Date : " + courseStudent.getStudent().getRegisterDate());
			System.out.println("--------------------------------------------------------------");
		}
		assertTrue(courseStudents.size()>0); 
	}
	
	@Test
	void testGetStudentWithCourse() {
		
		System.out.println("testGetStudentWithCourse");
		
		Integer courseId = 15;
		Integer studentId = 2;
		
		CourseStudent courseStudent = courseStudentDao.getStudentWithCourse(15,2);
		if(courseStudent!=null) {
			System.out.println("--------------------------------------------------------------");
			System.out.println("Course Id : " + courseStudent.getCourse().getTitle());
			System.out.println("Student FirstName : " + courseStudent.getStudent().getFirstName());
			System.out.println("Student LastName : " + courseStudent.getStudent().getLastName());
			System.out.println("Student Email : " + courseStudent.getStudent().getEmail());
			System.out.println("Student Register Date : " + courseStudent.getStudent().getRegisterDate());
			System.out.println("--------------------------------------------------------------");
		}
		
		assertNotNull(courseStudent);
	}
	
	@Test
	void testDeleteStudentWithCourse() {
		System.out.println("testDeleteStudentWithCourse");
		
		Integer courseId = 15;
		Integer studentId = 2;
		
		courseStudentDao.deleteStudentIdandCourseId(courseId,studentId);
		
		CourseStudent courseStudent = courseStudentDao.getStudentWithCourse(15,2);
		if(courseStudent==null) {
			System.out.println("Silindiði için Bulunmadý..");
		}
		assertNull(courseStudent);
	}
	

	
	@AfterAll
	public static void tearDownClass() {
		System.out.println("tearDownClass");
		courseStudentDao.HibernateSessionFactoryClose();
	}

}
