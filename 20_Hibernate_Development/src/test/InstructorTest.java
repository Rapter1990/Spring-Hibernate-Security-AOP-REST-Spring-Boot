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

import dao.InstructorDao;
import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;


class InstructorTest {

	static InstructorDao instructorDao = null;
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@BeforeAll
	public static void setUpClass() {
		System.out.println("setUpClass");

		instructorDao = new InstructorDao();
	}
	
	@Test
	void testCreateInstructor() {
		
		Instructor instructor = new Instructor();
		instructor.setFirstName("Daniel");
		instructor.setLastName("Tomas");
		instructor.setEmail("h@g.com");
		
		File file = new File("C:\\Users\\Noyan\\Desktop\\Adsýz.png");
        byte[] imageBytes = new byte[(int) file.length()];
 
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(imageBytes);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        instructor.setImage(imageBytes);
        
        // InstructorDetail (One - to - one)
        InstructorDetail instructorDetail = new InstructorDetail();
        instructorDetail.setYoutubeChannel("Youtube Channel");
        instructorDetail.setHobby("Skiing");
        instructor.setInstructorDetail(instructorDetail);
        
        
        Instructor createdInstructor = instructorDao.create(instructor);
		assertTrue(createdInstructor.getId()>0); 
        
	}
	
	@Test
	void testgetInstructorById() {
		System.out.println("testgetInstructorById");
		Integer id = 8;
		Instructor instructor = instructorDao.get(id);
		if(instructor!=null) {
			System.out.println("Student firstname : " + instructor.getFirstName());
			System.out.println("Student lastname : " + instructor.getLastName());
			System.out.println("Student email : " + instructor.getEmail());
			InstructorDetail instructorDetail = instructor.getInstructorDetail();
			System.out.println("InstructorDetail YOUTUBE channel : " + instructorDetail.getYoutubeChannel());
			System.out.println("InstructorDetail hobby : " + instructorDetail.getHobby());
		}

		assertNotNull(instructor);
	}
	
	@Test
	public void testListAllInstructors() {
		System.out.println("testListAllInstructors");
		List<Instructor> instructors = instructorDao.listAll();
		for(Instructor instructor : instructors) {
			System.out.println("------------------------------------------------------------");
			System.out.println("ID : " + instructor.getId());
			System.out.println("Student firstname : " + instructor.getFirstName());
			System.out.println("Student lastname : " + instructor.getLastName());
			System.out.println("Student email : " + instructor.getEmail());
			InstructorDetail instructorDetail = instructor.getInstructorDetail();
			System.out.println("InstructorDetail YOUTUBE channel : " + instructorDetail.getYoutubeChannel());
			System.out.println("InstructorDetail hobby : " + instructorDetail.getHobby());
			System.out.println("------------------------------------------------------------");
		}
		assertTrue(instructors.size()>0);
	}
	
	@Test
	public void testUpdateInstructor() {
		System.out.println("testUpdateInstructor");
		Integer id = 8;
		Instructor instructor = instructorDao.get(id);
		instructor.setFirstName("Yaðmur");
		instructor.setLastName("Þakiroðlu");
		instructor.setEmail("y@s.com");
		
		File file = new File("C:\\Users\\Noyan\\Desktop\\Adsýz.png");
        byte[] imageBytes = new byte[(int) file.length()];
 
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(imageBytes);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        instructor.setImage(imageBytes);
		
		InstructorDetail instructorDetail = instructor.getInstructorDetail();
		instructorDetail.setYoutubeChannel("Yaðmur ile Dans");
		instructorDetail.setHobby("Bilgisayar Oyunlarý");
		
		instructor.setInstructorDetail(instructorDetail);
		
		Instructor updatedInstructor = instructorDao.update(instructor);
		assertTrue(updatedInstructor.getId()>0); 
	}
	
	@Test
	public void testDeleteInstructor() {
		System.out.println("testDeleteInstructor");
		Integer id = 8;
		instructorDao.delete(id);
		
		Instructor instructor = instructorDao.get(id);
		if(instructor==null) {
			System.out.println("Silindiði için Bulunmadý..");
		}
		assertNull(instructor);
	}
	
	@AfterAll
	public static void tearDownClass() {
		System.out.println("tearDownClass");
		instructorDao.HibernateSessionFactoryClose();
	}

}
