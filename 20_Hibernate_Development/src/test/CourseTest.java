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
import dao.InstructorDao;
import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;


class CourseTest {

	static CourseDao courseDao = null;
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@BeforeAll
	public static void setUpClass() {
		System.out.println("setUpClass");

		courseDao = new CourseDao();
	}
	
	@Test
	void testCreateCourse() {
		
		Course newCourse = new Course();
		
		// Instructor
		int id = 6;
		Instructor instructor = new Instructor();
		instructor.setId(id);
		newCourse.setInstructor(instructor);
		
		newCourse.setTitle("Ýþ Eðitim Uygulamasý");
		
		Course createdCourse = courseDao.create(newCourse);
		assertTrue(createdCourse.getId()>0); 
        
	}
	
	@Test
	void testGetCourseById() {
		System.out.println("testGetCourseById");
		Integer id = 14;
		Course course = courseDao.get(id);
		if(course!=null) {
			System.out.println("-------------------------------------------------");
			System.out.println("Course ID : " + course.getId());
			System.out.println("Course Title: " + course.getTitle());
			System.out.println("Instructor : " + course.getInstructor().getFirstName() + " " + course.getInstructor().getLastName() );
			System.out.println("-------------------------------------------------");
		}
		assertNotNull(course);
	}
	
	
	@Test
	void testAllCourses() {
		System.out.println("testAllCourses");
		List<Course> courses = courseDao.listAll();
		for(Course course : courses) {
			System.out.println("-------------------------------------------------");
			System.out.println("Course ID : " + course.getId());
			System.out.println("Course Title: " + course.getTitle());
			System.out.println("Instructor : " + course.getInstructor().getFirstName() + " " + course.getInstructor().getLastName() );
			System.out.println("-------------------------------------------------");
		}
		assertTrue(courses.size()>0);
	}
	
	@Test
	void testUpdateCourse() {
		System.out.println("testUpdateCourse");
		Integer id = 14;
		Course course = courseDao.get(id);
		
		// Instructor
		int instructorId = 6;
		Instructor instructor = new Instructor();
		instructor.setId(instructorId);
		course.setInstructor(instructor);
		
		course.setTitle("Ýþ Uygulamasý ve Eðitimi");
		
		Course updatedCourse = courseDao.update(course);
		assertTrue(updatedCourse.getId()>0); 
	}
	
	@Test
	void testDeleteCourse() {
		System.out.println("testDeleteCourse");
		Integer id = 14;
		courseDao.delete(id);
		
		Course course = courseDao.get(id);
		if(course==null) {
			System.out.println("Silindiði için Bulunmadý..");
		}
		assertNull(course);
	}
	
	
	@AfterAll
	public static void tearDownClass() {
		System.out.println("tearDownClass");
		courseDao.HibernateSessionFactoryClose();
	}

}
