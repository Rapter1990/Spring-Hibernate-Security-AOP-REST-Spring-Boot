package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.CourseStudent;

public class CourseStudentDao extends HibernateDao<CourseStudent> implements GeneticDao<CourseStudent>{


	public CourseStudentDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public CourseStudent create(CourseStudent t) {
		// TODO Auto-generated method stub
		return super.create(t);
	}

	@Override
	public CourseStudent update(CourseStudent t) {
		// TODO Auto-generated method stub
		return super.update(t);
	}

	@Override
	public CourseStudent get(Object id) {
		// TODO Auto-generated method stub
		return super.get(CourseStudent.class, id);
	}

	@Override
	public void delete(Object id) {
		// TODO Auto-generated method stub
		super.delete(CourseStudent.class, id);
	}

	@Override
	public List<CourseStudent> listAll() {
		// TODO Auto-generated method stub
		return super.getListAll("CourseStudent.findAll");
	}


	public long count(int courseId) {
		// TODO Auto-generated method stub
		return super.getCountByNameQuery("CourseStudent.countByCourse","courseId",courseId);
	}
	
	public CourseStudent getStudentWithCourse(int courseId,int studentId) {
		// TODO Auto-generated method stub
		Map<String,Object> maps = new HashMap<>();
		maps.put("courseId", courseId);
		maps.put("studentId", studentId);
		
		CourseStudent courseStudent = new CourseStudent();
		
		List<CourseStudent> list = super.findByNameQuery("CourseStudent.studentWithCourse", maps);
		
		if(list.size()>0) {
			courseStudent = list.get(0);
		}else {
			courseStudent = null;
		}
		
		return courseStudent;
	}
	
	public List<CourseStudent> listStudentsWithCourse(int courseId) {
		// TODO Auto-generated method stub
		return super.findByNameQuery("CourseStudent.studentsByCourse","courseId",courseId);
	}
	
	public void deleteStudentIdandCourseId(int courseId,int studentId) {
		Map<String,Object> maps = new HashMap<>();
		maps.put("courseId", courseId);
		maps.put("studentId", studentId);
		super.deleteByNameQueryObjects("CourseStudent.deleteObjectwithStudentIdAndCourseId",maps);
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

}
