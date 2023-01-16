package com.ty.many_to_many_uni.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ty.many_to_many_uni.dao.Course_CRUD;
import com.ty.many_to_many_uni.dao.Student_CRUD;
import com.ty.many_to_many_uni.dto.Course;
import com.ty.many_to_many_uni.dto.Student;

public class Class_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		Student_CRUD crud=new Student_CRUD();
		Course_CRUD crud2=new  Course_CRUD();
		List<Student> list1=new ArrayList<Student>();
		List<Course> list=new ArrayList<Course>();
		System.out.println("Enter the choice");
		System.out.println("Enter 1 to save person");
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:{
			int num = 1;
			while (num <= 2){
				Course c1=new Course();
				System.out.println("Enter the Course id");
				int id=sc.nextInt();
				System.out.println("Enter the Course name");
				String name=sc.next();
				System.out.println("Enter the cost");
				double cost=sc.nextDouble();
				
				c1.setId(id);
				c1.setName(name);
				c1.setCost(cost);
				
				
				list.add(c1);
				
				num++;
			}
		}
		case 2:
		{
			int num=1;
			while(num<=2)
			{
				System.out.println("Enter the Student id");
				int id=sc.nextInt();
				System.out.println("Enter the Student name");
				String name=sc.next();
				System.out.println("Enter the address");
				String address=sc.next();
				System.out.println("Enter the marks");
				int marks=sc.nextInt();
				
				Student s1=new Student();
				s1.setId(id);
				s1.setName(name);
				s1.setAddress(address);
				s1.setMarks(marks);
				
				s1.setCourses(list);
				
				list1.add(s1);
				num++;
				
			}
			crud.saveStudent(list1);
			crud2.saveCourse(list);
		}
		case 3: {
			System.out.println("Enter choice to update \n1:Student \n:2 Courses");
			int choice1 = sc.nextInt();
			switch (choice1) {
			case 1: {
				System.out.println("Enter id of Student");
				int id = sc.nextInt();
				System.out.println("Enter to change Student name");
				String name = sc.next();
				Student s1 = new Student();
				s1.setId(id);
				s1.setName(name);
				crud.updateStudent(s1);
			}
				break;
			case 2: {
				System.out.println("Enter id of lang");
				int id = sc.nextInt();
				System.out.println("Enter to change course name");
				String name = sc.next();
				Course c1 = new Course();
				c1.setId(id);
				c1.setName(name);
				crud2.updateCourse(c1);
			} 
			}
		} 
			break;
			
		case 4: {
			System.out.println("Enter choice to delete \n1:Student \n:2 Courses");
			int choice1 = sc.nextInt();
			switch (choice1) {
			case 1: {
				System.out.println("Enter id of Student");
				int id = sc.nextInt();

				Student s1 = new Student();
				s1.setId(id);

				crud.removeStudent(s1);
			}
				break;
			case 2: {
				System.out.println("Enter id of course");
				int id = sc.nextInt();

				Course c1 = new Course();
				c1.setId(id);

				crud2.removeCourse(c1);
			} 
			}
		} break;
		
		case 5:{
			System.out.println("Enter id of Student");
			Student s1 = new Student();
			int id = sc.nextInt();
			s1.setId(id);
			crud.getAllStudentId(s1);

		}
		break;
		}
		}
}

