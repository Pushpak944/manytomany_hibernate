package com.ty.many_to_many_uni.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.many_to_many_uni.dto.Course;
import com.ty.many_to_many_uni.dto.Student;

public class Course_CRUD {

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}
	
	public void saveCourse(List<Course> list)
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		for(Course course:list)
		{
			entityTransaction.begin();
			entityManager.persist(course);
			entityTransaction.commit();
		}
	}
	
	public void updateCourse(Course course)
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Course	course1 =entityManager.find(Course.class, course.getId());
		course1.setName(course.getName());
		entityTransaction.begin();
		entityManager.merge(course1);
		entityTransaction.commit();
	}
	
	public void removeCourse(Course course)
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Course course2 =entityManager.find(Course.class, course.getId());
		course2.setName(course.getName());
		entityTransaction.begin();
		entityManager.remove(course2);
		entityTransaction.commit();
	}
	
	
}
