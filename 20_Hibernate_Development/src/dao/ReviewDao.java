package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Course;
import entity.Review;

public class ReviewDao extends HibernateDao<Review> implements GeneticDao<Review>{
	
	
	public ReviewDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public Review create(Review t) {
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
	public Review update(Review t) {
		// TODO Auto-generated method stub
		return super.update(t);
	}



	@Override
	public Review get(Object id) {
		// TODO Auto-generated method stub
		return super.get(Review.class, id);
	}

	@Override
	public void delete(Object id) {
		// TODO Auto-generated method stub
		super.delete(Review.class, id);
	}

	@Override
	public List<Review> listAll() {
		// TODO Auto-generated method stub
		return super.getListAll("Review.findAll");
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return super.getCountAll("Review.countAll");
	}
	
	public long countByCustomer(int courseId) {
		return super.getCountByNameQuery("Review.countByCourse", "courseId", courseId);
	}
	
	public List<Review> listReviewsByCourse(int courseId) {
		//return super.findByNameQuery("DetailOrder.bestSelling", 0, 4);
			
		List<Review> result = super.findByNameQuery("Review.findByCourse","courseId", courseId);
		
		return result;
	}	
	
}
