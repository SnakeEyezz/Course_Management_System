package com.coursemanagement.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coursemanagement.dto.CourseDTO;

@Repository
public class CourseDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addCourse(CourseDTO course) {
		
		sessionFactory.getCurrentSession().save(course);
	}
	
	@SuppressWarnings("unchecked")
	public List<CourseDTO> listCourse() {
		
		return sessionFactory.getCurrentSession().createQuery("from CourseDTO").list();
	}
	
	@SuppressWarnings("unchecked")
	public CourseDTO getCourseById(int courseId) {
		
		Session session = sessionFactory.getCurrentSession();
		List<CourseDTO> list = session.createQuery("from CourseDTO c where c.courseId= :courseId")
								 .setParameter("courseId", courseId).list();
		return  list.size()>0 ? (CourseDTO)list.get(0): null;
	}
	
	public void updateCourse(CourseDTO course) {
		
		sessionFactory.getCurrentSession().update(course);
	}

}