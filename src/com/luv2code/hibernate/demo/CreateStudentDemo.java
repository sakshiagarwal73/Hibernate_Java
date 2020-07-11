package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();//session factory //created only once //heavy-weight
				                 
        Session session = factory.getCurrentSession(); //created per session
        
        try {
        	//create student object
        	Student s = new Student("Sonakshi","Sen","SonakshiSen@gmail.com");
        	
        	//begin the transaction
        	session.beginTransaction();
        	
        	//save the object
        	session.save(s);
        	
        	//commit the transaction
        	session.getTransaction().commit();
        	
        	System.out.println("Student id is: " + s.getId());
        	System.out.println("Done!");
        }
        
        finally {
        	
        	factory.close();
        }
	}

}
