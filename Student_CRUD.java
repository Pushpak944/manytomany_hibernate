package com.ty.many_to_many_uni.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.many_to_many_uni.dto.Student;

public class Student_CRUD {

	
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}
	
	public void saveStudent(List<Student> list)
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		for(Student student:list)
		{
			entityTransaction.begin();
			entityManager.persist(student);
			entityTransaction.commit();
		}
	}
	
	public void updateStudent(Student student)
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Student	student1 =entityManager.find(Student.class, student.getId());
		student1.setName(student.getName());
		entityTransaction.begin();
		entityManager.merge(student1);
		entityTransaction.commit();
	}
	
	public void removeStudent(Student student)
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Student student2=entityManager.find(Student.class, student.getId());
		student2.setName(student.getName());
		entityTransaction.begin();
		entityManager.remove(student2);
		entityTransaction.commit();
	}
	
	public void getAllStudentId(Student student)
	{
		EntityManager entityManager=getEntityManager();
		Student student2=entityManager.find(Student.class, student.getId());
		List<Student> list=new ArrayList<Student>();
		list.add(student2);
		System.out.println(student2);
	}
}
