package dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import util.HibernateUtil;


public abstract class HibernateDao<T> {

	 protected static SessionFactory sessionFactory;
	 
	 static {
		 sessionFactory = HibernateUtil.getSessionFactory();
	 }
	 
	 public HibernateDao() {
		// TODO Auto-generated constructor stub
	 }
	
	 
	
	public T create(T t) {
		 
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			
			session.persist(t);
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
	 
	public T update(T t) {
		
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			
			session.update(t);
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
	
	public T get(Class<T> type,Object id) {
		
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		T t = null;
		try {
			transaction = session.beginTransaction();
			
			t = session.get(type, (int)id);
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
	
	public void delete(Class<T> type,Object id) {
		T t = get(type, id);
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			
			session.delete(t);
			
			session.flush();
			session.getTransaction().commit();
			session.close();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.rollback();
		}
		 
	}
	
	public List<T> getListAll(String nameQuery){
		
		List<T> t=null;
		
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createNamedQuery(nameQuery);
			t=query.getResultList();
			
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
	
	public long getCountAll(String nameQuery) {
		
		long count = 0;
		
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createNamedQuery(nameQuery);
			count=(long) query.getSingleResult();
			
			session.flush();
			session.getTransaction().commit();
			session.close();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.rollback();
		}
		
		return count;
	}
	
	public long getCountByNameQuery(String nameQuery, String paramName, Object paramValue) {
		
		long count = 0;
		
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createNamedQuery(nameQuery);
			query.setParameter(paramName, paramValue);
			
			count=(long) query.getSingleResult();
			
			session.flush();
			session.getTransaction().commit();
			session.close();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.rollback();
		}
		
		return count;
	}
	
	public List<T> findByNameQuery(String nameQuery, String paramName, Object paramValue) {
		// TODO Auto-generated method stub
		List<T> t=null;
		
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createNamedQuery(nameQuery);
			query.setParameter(paramName, paramValue);
			t=query.getResultList();
			
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
	
	public List<T> findByNameQuery(String nameQuery, Map<String,Object> parameters) {
		// TODO Auto-generated method stub
		List<T> t=null;
		
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createNamedQuery(nameQuery);
			
			Set<Map.Entry<String,Object>> s = parameters.entrySet();
			 
			for(Map.Entry<String, Object> entry: s) {
				query.setParameter(entry.getKey(), entry.getValue());
			}
			
			/*for(Entry entry : map.entrySet()){
			  query.setParameter(entry.getkey(),entry.getValue())
			}*/
		
			t=query.getResultList();
			
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
	
	public List<T> findByNameQuery(String nameQuery, int firstResult, int maxResults) {
		
		List<T> t=null;
		
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createNamedQuery(nameQuery);
			query.setFirstResult(firstResult);
			query.setMaxResults(maxResults);
					
			t=query.getResultList();
			
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
	
	public List<Object[]> findByNameQueryObjects(String queryName, int firstResult, int maxResults) {
		
		
		List<Object[]> result=null;
		
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createNamedQuery(queryName);
			query.setFirstResult(firstResult);
			query.setMaxResults(maxResults);
					
			result=query.getResultList();
			
			session.flush();
			session.getTransaction().commit();
			session.close();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.rollback();
		}
		
		return result;
		
	}
	
	public List<Object[]> findByNameQueryObjects(String queryName) {
		
		
		List<Object[]> result=null;
		
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createNamedQuery(queryName);
					
			result=query.getResultList();
			
			session.flush();
			session.getTransaction().commit();
			session.close();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.rollback();
		}
		
		return result;
		
	}
	
	public void deleteByNameQueryObjects(String queryName,Map<String,Object> parameters) {
		
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			
			Query query = session.createNamedQuery(queryName);
			
			Set<Map.Entry<String,Object>> s = parameters.entrySet();
			 
			for(Map.Entry<String, Object> entry: s) {
				query.setParameter(entry.getKey(), entry.getValue());
			}
			
			query.executeUpdate();
			
			session.flush();
			session.getTransaction().commit();
			session.close();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.rollback();
		}
	}
	
	
	public void HibernateSessionFactoryClose() {
		sessionFactory.close();
	}
	
}
