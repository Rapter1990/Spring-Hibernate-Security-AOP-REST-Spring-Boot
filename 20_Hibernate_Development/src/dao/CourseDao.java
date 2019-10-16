package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Course;

public class CourseDao extends HibernateDao<Course> implements GeneticDao<Course>{
	
	
	public CourseDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public Course create(Course t) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			
			session.saveOrUpdate(t);
			session.flush();
			session.getTransaction().commit();
			session.close();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.rollback();
		}
		 
		return t;
	}

	
	@Override
	public Course update(Course t) {
		// TODO Auto-generated method stub
		return super.update(t);
	}


	@Override
	public Course get(Object id) {
		// TODO Auto-generated method stub
		return super.get(Course.class, id);
	}

	@Override
	public void delete(Object id) {
		// TODO Auto-generated method stub
		super.delete(Course.class, id);
	}

	@Override
	public List<Course> listAll() {
		// TODO Auto-generated method stub
		return super.getListAll("Course.findAll");
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return super.getCountAll("Course.countAll");
	}
	
	public List<Course> listCoursesByInstructor() {
		//return super.findByNameQuery("DetailOrder.bestSelling", 0, 4);
		
		List<Course> listCourses = new ArrayList<>();
		
		List<Object[]> result = super.findByNameQueryObjects("Course.findByInstructor");
		
		if (!result.isEmpty()) {
			for (Object[] elements : result) {
				int courseId = (int) elements[0];
				Course course = get(courseId);
				listCourses.add(course);
			}
		} 
		
		return listCourses;
	}	

}
