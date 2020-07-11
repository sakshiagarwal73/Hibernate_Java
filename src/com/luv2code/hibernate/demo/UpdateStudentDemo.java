package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();//session factory //created only once //heavy-weight
				                 
        Session session = factory.getCurrentSession(); //created per session
        
        try {
        	
        	
        	
        	int studentid = 1;
        	
        	
        	
        	
        	
        	session.beginTransaction();
        	
        	
        	
        	Student sget = session.get(Student.class,studentid);
        	
        	System.out.println("Before: " + sget);
        	
        	//use setter method
        	sget.setFirstName("Ananya");
        	
        	System.out.println("After: " + sget);
        	
        	//commit will update 
        	session.getTransaction().commit();
        	
        	session = factory.getCurrentSession();
        	
        	session.beginTransaction();
        	
        	//update query 
        	session.createQuery("update Student  set lastName = 'Mittal' where lastName = 'Sen' ").executeUpdate();
        	
        	session.getTransaction().commit();
        	
        	System.out.println("Done!");
        	
        }
        
        finally {
        	
        	factory.close();
        }
	}

}
