package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Rule;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import dao.ReviewDao;
import entity.Course;
import entity.Instructor;
import entity.Review;



class ReviewTest {

	static ReviewDao reviewDao = null;
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@BeforeAll
	public static void setUpClass() {
		System.out.println("setUpClass");

		reviewDao = new ReviewDao();
	}
	
	@Test
	void testCreateReview() {
		
		Review newReview = new Review();
		
		Course course = new Course("Ýþ Uygulamasý ve Eðitimi");
		Integer courseId = 14;
		course.setId(courseId);
		newReview.setCourse(course);
		
		int id = 6;
		Instructor instructor = new Instructor();
		instructor.setId(id);
		course.setInstructor(instructor);
		
		newReview.setComment("Bu kurs çok güzel");
		
		Review createdReview = reviewDao.create(newReview);
		assertTrue(createdReview.getId()>0); 
		
	}
	
	@Test
	void testReviewById() {
		System.out.println("testReviewById");
		Integer id = 3;
		Review review = reviewDao.get(id);
		if(review!=null) {
			System.out.println("-------------------------------------------------");
			System.out.println("Review ID : " + review.getId());
			System.out.println("Review Comment: " + review.getComment());
			System.out.println("Course : " + review.getCourse().getTitle() );
			System.out.println("-------------------------------------------------");
		}
		assertNotNull(review);
	}
	
	@Test
	void testAllReviews() {
		System.out.println("testAllReviews");
		List<Review> reviews = reviewDao.listAll();
		for(Review review : reviews) {
			System.out.println("-------------------------------------------------");
			System.out.println("Review ID : " + review.getId());
			System.out.println("Review Comment: " + review.getComment());
			System.out.println("Course : " + review.getCourse().getTitle() );
			System.out.println("-------------------------------------------------");
		}
		assertTrue(reviews.size()>0);
	}
	
	@Test
	void testUpdateReview() {
		System.out.println("testUpdateReview");
		Integer id = 3;
		Review review = reviewDao.get(id);
		
		Course course = new Course("Ýþ Uygulamasý ve Eðitimi");
		Integer courseId = 14;
		course.setId(courseId);
		review.setCourse(course);
		
		int instructorId = 6;
		Instructor instructor = new Instructor();
		instructor.setId(instructorId);
		course.setInstructor(instructor);
		
		review.setComment("Bu kurs alýnmaya deðmez");
		
		Review updatedReview = reviewDao.update(review);
		assertTrue(updatedReview.getId()>0); 
	}
	
	@Test
	void testDeleteReview() {
		System.out.println("testDeleteReview");
		Integer id = 3;
		reviewDao.delete(id);
		
		Review review = reviewDao.get(id);
		if(review==null) {
			System.out.println("Silindiði için Bulunmadý..");
		}
		assertNull(review);
	}
	
	@Test
	void testReviewByCourse() {
		System.out.println("testReviewByCourse");
		Integer courseId = 14;
		List<Review> listReviewByCourse = reviewDao.listReviewsByCourse(courseId);
		for(Review review : listReviewByCourse) {
			System.out.println("-------------------------------------------------");
			System.out.println("Review ID : " + review.getId());
			System.out.println("Review Comment: " + review.getComment());
			System.out.println("Course ID : " + review.getCourse().getId() );
			System.out.println("Course : " + review.getCourse().getTitle() );
			System.out.println("-------------------------------------------------");
		}
		assertTrue(listReviewByCourse.size()>0);
	}
	
	@AfterAll
	public static void tearDownClass() {
		System.out.println("tearDownClass");
		reviewDao.HibernateSessionFactoryClose();
	}

}
