package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory=new Configuration()
							   .configure("hibernate.cfg.xml")
							   .addAnnotatedClass(Student.class)
							   .buildSessionFactory();
		
		// create session
		Session session=factory.getCurrentSession();
		
		try {
						
			//query students
			List<Student>theStudents=session.createQuery("from Student").list();
			
			//display the students
			displayStudents(theStudents);
			
			//query students:lastName='Doe'
			theStudents=session.createQuery("from Student s where s.lastName='Doe'").list();
			
			//display the students
			System.out.println("Students who have last name of Doe");
			displayStudents(theStudents);		
			
			//query students:lastName='Doe' OR firstName="Daffy'
			theStudents=
					session.createQuery("from Students s where"+"s.lastName='Doe' OR s.firstName='Daffy'").list();
			System.out.println("\n\nStudents who have last name of Doe OR first name Daff");
			displayStudents(theStudents);
					
			//query students where email Like '%luv2code.com'
			theStudents=session.createQuery("from Student s where"+"s.email Like '%luv2code'").list();
			
			System.out.println("\n\nStusents whose email ends with luv2code.com");
			displayStudents(theStudents);
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("done");		
			
		}finally {
			factory.close();
		}
		
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent:theStudents) {
			System.out.println(tempStudent);
		}
	}
}
