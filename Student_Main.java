package com.ty.many_to_many_uni.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.many_to_many_uni.dto.Course;
import com.ty.many_to_many_uni.dto.Student;

public class Student_Main {
	public static void main(String[] args) {
		Student s1=new Student();
		s1.setAddress("kankapura");
		s1.setMarks(78);
		s1.setName("akash");
		
		Student s2=new Student();
		s2.setAddress("hosur");
		s2.setMarks(98);
		s2.setName("james");
		
		Student s3=new Student();
		s3.setAddress("kormangala");
		s3.setMarks(78);
		s3.setName("gagag");
		
		Course c1=new Course();
		c1.setName("java");
		c1.setCost(8897);
		
		Course c2=new Course();
		c2.setName("python");
		c2.setCost(9887);
		
		Course c3=new Course();
		c3.setName("advance");
		c3.setCost(987);
		
		List<Course> list=new ArrayList<Course>();
		list.add(c1);
		list.add(c2);
		
		s1.setCourses(list);
		s2.setCourses(list);
		
		List<Course> list1=new ArrayList<Course>();
		list1.add(c3);
		list1.add(c2);
		s3.setCourses(list1);
		
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(c1);
		entityManager.persist(c2);
		entityManager.persist(c3);
		entityManager.persist(s1);
		entityManager.persist(s2);
		entityManager.persist(s3);
		entityTransaction.commit();
		
	}
}



















