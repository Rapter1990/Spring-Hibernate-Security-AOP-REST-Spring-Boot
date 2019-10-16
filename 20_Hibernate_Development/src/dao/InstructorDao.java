package dao;

import java.util.List;

import entity.Instructor;
import entity.Student;

public class InstructorDao extends HibernateDao<Instructor> implements GeneticDao<Instructor>{

	public InstructorDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Instructor create(Instructor t) {
		// TODO Auto-generated method stub
		return super.create(t);
	}
	
	@Override
	public Instructor update(Instructor t) {
		// TODO Auto-generated method stub
		return super.update(t);
	}

	@Override
	public Instructor get(Object id) {
		// TODO Auto-generated method stub
		return super.get(Instructor.class, id);
	}

	@Override
	public void delete(Object id) {
		// TODO Auto-generated method stub
		super.delete(Instructor.class, id);
	}

	@Override
	public List<Instructor> listAll() {
		// TODO Auto-generated method stub
		return super.getListAll("Instructor.findAll");
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return super.getCountAll("Instructor.countAll");
	}

}
