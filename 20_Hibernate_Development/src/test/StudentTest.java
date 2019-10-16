package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Rule;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import dao.StudentDao;
import entity.Student;

class StudentTest {

	static StudentDao studentDao = null;
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@BeforeAll
	public static void setUpClass() {
		System.out.println("setUpClass");

		//BaseDaoTest.setUpClass();
		//bookDao = new BookDao(sessionFactory);
		studentDao = new StudentDao();
	}
	
	@Test
	void testCreateStudent() throws ParseException {
		
		Student student = new Student();
		
		// Student information as firstName,lastName,Email
		student.setFirstName("Ali");
		student.setLastName("Göktuð");
		student.setEmail("a@g.com");
		
		// Student information as Date
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/mm/yyyy");
		Date registerDate = dateformat.parse("25/07/2019");
		student.setRegisterDate(registerDate); 
		
		// Student information as image
		File file = new File("C:\\Users\\Noyan\\Desktop\\Adsýz.png");
        byte[] imageBytes = new byte[(int) file.length()];
 
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(imageBytes);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        student.setImage(imageBytes);
        
        Student createdStudent = studentDao.create(student);
		assertTrue(createdStudent.getId()>0); 
		
	}
	
	@Test
	void testgetStudentById() {
		System.out.println("testgetStudentById");
		Integer id = 2;
		Student student = studentDao.get(id);
		if(student!=null) {
			System.out.println("Student firstname : " + student.getFirstName());
			System.out.println("Student lastname : " + student.getLastName());
			System.out.println("Student email : " + student.getEmail());
			System.out.println("Student registerdate : " + student.getRegisterDate());
		}

		assertNotNull(student);
	}
	
	@Test
	public void testListAllStudents() {
		System.out.println("testListAllStudents");
		List<Student> students = studentDao.listAll();
		for(Student student : students) {
			System.out.println("------------------------------------------------------------");
			System.out.println("ID : " + student.getId());
			System.out.println("Student firstname : " + student.getFirstName());
			System.out.println("Student lastname : " + student.getLastName());
			System.out.println("Student email : " + student.getEmail());
			System.out.println("Student registerdate : " + student.getRegisterDate());
			System.out.println("------------------------------------------------------------");
		}
		assertTrue(students.size()>0);
	}
	
	@Test
	public void testUpdateStudent() throws ParseException {
		Integer id = 2;
		Student student = studentDao.get(id);
		
		// Student information as firstName,lastName,Email
		student.setFirstName("Gizem");
		student.setLastName("Hacýþakiroðlu");
		student.setEmail("g@h.com");
		
		// Student information as Date
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/mm/yyyy");
		Date registerDate = dateformat.parse("25/08/2019");
		student.setRegisterDate(registerDate); 
		
		// Student information as image
		File file = new File("C:\\Users\\Noyan\\Desktop\\Adsýz.png");
        byte[] imageBytes = new byte[(int) file.length()];
 
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(imageBytes);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        student.setImage(imageBytes);
        
        Student updatedStudent = studentDao.update(student);
		assertTrue(updatedStudent.getId()>0); 
	}
	
	@Test
	public void testDeleteStudent() {
		System.out.println("testDeleteStudent");
		Integer id = 2;
		studentDao.delete(id);
		
		Student student = studentDao.get(id);
		if(student==null) {
			System.out.println("Silindiði için Bulunmadý..");
		}
		assertNull(student);
	}
	
	@AfterAll
	public static void tearDownClass() {
		System.out.println("tearDownClass");
		studentDao.HibernateSessionFactoryClose();
	}

}
