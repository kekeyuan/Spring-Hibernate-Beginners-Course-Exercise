package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("thatSillyCoach")
public class TennisCoach implements Coach {

	@Autowired
	private FortuneService fortuneService;
	
	//define a default constructor
	public TennisCoach() {
		System.out.println(">>TennisCoach:inside default constructor");
	}
	
	//define a setter method 
	/*@Autowired
	public void setFortuneService(FortuneService theFortuneService) {
		System.out.println(">>TennisCoach:inside setFortuneService() method");
		fortuneService=theFortuneService;
	}*/
	
	/*public TennisCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}*/
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}