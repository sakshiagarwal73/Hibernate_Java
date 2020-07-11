package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();//session factory //created only once //heavy-weight
				                 
        Session session = factory.getCurrentSession(); //created per session
        
        try {
        	//create student object
        	Student s = new Student("Sakshi","Agarwal","Sakshi@gmail.com");
        	
        	//begin the transaction
        	session.beginTransaction();
        	
        	//save the object
        	session.save(s);
        	
        	//commit the transaction
        	session.getTransaction().commit();
        	
        	
        	System.out.println("student created:  " + s);
        	
        	
        	
        	//retrieve the student
        	
        	//create another session object
        	
        	session = factory.getCurrentSession();
        	session.beginTransaction();
        	
        	//print the primary key
        	System.out.println("Getting student with id: " + s.getId());
        	
        	Student sget = session.get(Student.class, s.getId());
        	
        	//print the entire student details
        	System.out.println("student retrieved:  " + sget);
        	
        	session.getTransaction().commit();
        	
        	System.out.println("Done!");
        	
        }
        
        finally {
        	
        	factory.close();
        }
	}

}
