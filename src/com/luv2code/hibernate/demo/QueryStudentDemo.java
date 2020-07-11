package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();//session factory //created only once //heavy-weight
				                 
        Session session = factory.getCurrentSession(); //created per session
        
        try {
        	
        	
        	//begin the transaction
        	session.beginTransaction();
        	
        	//query all students
        	List<Student> list_student = session.createQuery("from Student").list(); //Student - same as class name//not table name
        	
        	//displayStudents(list_student);
        	
        	//query all students with last name as "Sen"
        	
        	//where clause
        	list_student = session.createQuery("from Student s where s.lastName= 'Sen' ").list();
        	//lastName --- same as field in Class and not as Column name in table
        	
        	//displayStudents(list_student);
        	
        	//OR clause
        	list_student = session.createQuery("from Student s where s.lastName = 'Sen'" +
        	" OR s.firstName = 'Sonakshi'").list();
        	
        	//displayStudents(list_student);
        	
        	//LIKE clause
        	list_student = session.createQuery("from Student s where s.email LIKE '%@gmail.com'").list();
        	
        	displayStudents(list_student);
        	
        	//commit the transaction
        	session.getTransaction().commit();
        	
        	
        	System.out.println("Done!");
        }
        
        finally {
        	
        	factory.close();
        }
	}

	private static void displayStudents(List<Student> list_student) {
		for(Student s: list_student)
		{
			System.out.println(s);
		}
	}

}
