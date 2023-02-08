package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory=new Configuration()
							   .configure("hibernate.cfg.xml")
							   .addAnnotatedClass(Instructor.class)
							   .addAnnotatedClass(InstructorDetail.class)
							   .buildSessionFactory();
		
		// create session
		Session session=factory.getCurrentSession();
		
		try {
			//create the objects
			Instructor tempInstructor=new Instructor("ke","yuan","ke@luv2code.com", null);
			
			InstructorDetail tempInstructorDetail=new InstructorDetail(
					"http://www.luv2code.com/youtube","luv2paint!!!");
			
			//associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			//start a transaction
			session.beginTransaction();
			
			//save the instructor(save all the details)
			System.out.println("Saving instructor:"+tempInstructor);
			session.save(tempInstructor);

			//commit the transaction
			session.getTransaction().commit();
			System.out.println("done");		
			
		}finally {
			factory.close();
		}
		
	}
}
