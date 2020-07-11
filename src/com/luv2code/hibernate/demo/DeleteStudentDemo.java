package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();//session factory //created only once //heavy-weight
				                 
        Session session = factory.getCurrentSession(); //created per session
        
        try {
        	
        	
        	
        	int studentid = 3;
        	
        	
        	
        	
        	
        	session.beginTransaction();
        	
        	
        	//retrieve the object
        	Student sget = session.get(Student.class,studentid);
        	
        	
        	
        	//delete the object
        	session.delete(sget);
        	
        	
        	
        	//commit will update 
        	session.getTransaction().commit();
        	
        	session = factory.getCurrentSession();
        	
        	session.beginTransaction();
        	
        	//update query 
        	session.createQuery("delete from Student where lastName = 'Mittal'").executeUpdate();
        	
        	session.getTransaction().commit();
        	
        	System.out.println("Done!");
        	
        }
        
        finally {
        	
        	factory.close();
        }
	}

}
