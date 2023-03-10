package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get the bean from spring container
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
		
		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		// call method to the dailyFortune
		System.out.println(theCoach.getDailyFortune());		
		
		// call our new swim coach method..has the props value injected
		System.out.println("eamail:"+ theCoach.getEmail());
		System.out.println("team:"+ theCoach.getTeam());
		
		// close the context
		context.close();
		
	}

}


